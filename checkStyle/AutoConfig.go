package main

import (
	"bufio"
	"io"
	// "io/ioutil"
	// "bytes"
	"log"
	"os"
	"os/exec"
	"os/user"
	"path/filepath"
)

var (
	GIT_TEMPLATE_DIR                 = "/.git-templates/"
	HOOKS_DIR                        = "/.git-templates/hooks/"
	HOOKS_PRE_COMMIT_NAME            = "pre-commit"
	CHECK_STYLE_JAR_DIR              = "/.checkStyle/"
	CHECK_STYLE_JAR_NAME             = "checkstyle-8.9-all.jar"
	CHECK_STYLE_XML_LOCATION         = "http://182.254.158.159/share/checkStyle/raw/master/check-style.xml"
	GIT_CONFIG_KEY_CORE_HOOKS_PATH   = "core.hooksPath"
	GIT_CONFIG_KEY_INIT_TEMPLATE_DIR = "init.templatedir"
	GIT_CONFIG_KEY_CHECK_FILE        = "checkstyle.checkfile"
	GIT_CONFIG_KEY_CHECK_JAR         = "checkstyle.jar"
)

func main() {
	usr, err := user.Current()
	checkErr(err)
	homeDir := filepath.ToSlash(usr.HomeDir)

	GIT_TEMPLATE_DIR = homeDir + GIT_TEMPLATE_DIR
	HOOKS_DIR = homeDir + HOOKS_DIR
	CHECK_STYLE_JAR_DIR = homeDir + CHECK_STYLE_JAR_DIR

	log.Println("git template dir  ", GIT_TEMPLATE_DIR)
	log.Println("hooks dir  ", HOOKS_DIR)
	log.Println("check style jar dir  ", CHECK_STYLE_JAR_DIR)

	currentDirPath, err := filepath.Abs(filepath.Dir(os.Args[0]))
	checkErr(err)
	currentDirPath = filepath.ToSlash(currentDirPath) + "/"
	log.Println("current dir : " + currentDirPath)

	// var gitDirPath = currentDirPath
	// founded := false
	// searchMax := 10
	// search := 0
	// log.Println("search... .git dir")
	// for !founded && search < searchMax {
	// 	gitDirPath = filepath.Dir(gitDirPath)
	// 	files, err := ioutil.ReadDir(gitDirPath)
	// 	if err != nil {
	// 		log.Fatal(err)
	// 	}

	// 	for _, f := range files {
	// 		if f.Name() == ".git" {
	// 			founded = true
	// 		}
	// 	}
	// 	search++
	// }

	// if !founded {
	// 	log.Println(".git dir not found")
	// 	return
	// }
	// log.Println(".git dir found in " + gitDirPath)

	if _, err = os.Stat(HOOKS_DIR); os.IsNotExist(err) {
		log.Println("make hooks dir " + HOOKS_DIR)
		os.MkdirAll(HOOKS_DIR, os.ModePerm)
	}

	if _, err = os.Stat(CHECK_STYLE_JAR_DIR); os.IsNotExist(err) {
		log.Println("make check jar dir " + CHECK_STYLE_JAR_DIR)
		os.MkdirAll(CHECK_STYLE_JAR_DIR, os.ModePerm)
	}

	srcCheckStyleJarPath := currentDirPath + CHECK_STYLE_JAR_NAME
	destCheckStyleJarPath := CHECK_STYLE_JAR_DIR + CHECK_STYLE_JAR_NAME

	srcPreCommitFile := currentDirPath + HOOKS_PRE_COMMIT_NAME
	destPreCommitFile := HOOKS_DIR + HOOKS_PRE_COMMIT_NAME

	log.Println("copy pre-commit to " + HOOKS_DIR)
	copyFile(srcPreCommitFile, destPreCommitFile)

	log.Println("copy checkStyle jar to ", CHECK_STYLE_JAR_DIR)
	copyFile(srcCheckStyleJarPath, destCheckStyleJarPath)

	newPreCommit, err := os.Open(destPreCommitFile)
	checkErr(err)
	newPreCommit.Chmod(0777)

	cmd0 := exec.Command("git", "config", "--unset", GIT_CONFIG_KEY_CHECK_FILE)

	cmd1 := exec.Command("git", "config", "--unset", GIT_CONFIG_KEY_CHECK_JAR)

	cmd2 := exec.Command("git", "config", "--global", GIT_CONFIG_KEY_CORE_HOOKS_PATH, HOOKS_DIR)

	// log.Println("exec git config --global ", GIT_CONFIG_KEY_INIT_TEMPLATE_DIR, GIT_TEMPLATE_DIR)
	// cmd3 := exec.Command("git", "config", "--global", GIT_CONFIG_KEY_INIT_TEMPLATE_DIR, GIT_TEMPLATE_DIR)

	cmd4 := exec.Command("git", "config", "--global", GIT_CONFIG_KEY_CHECK_FILE, CHECK_STYLE_XML_LOCATION)

	cmd5 := exec.Command("git", "config", "--global", GIT_CONFIG_KEY_CHECK_JAR, destCheckStyleJarPath)

	log.Println("exec git config --unset ", GIT_CONFIG_KEY_CHECK_FILE)
	_ = cmd0.Run()
	// checkErr(err)

	log.Println("exec git config --unset ", GIT_CONFIG_KEY_CHECK_JAR)
	_ = cmd1.Run()
	// checkErr(err)

	log.Println("exec git config --global ", GIT_CONFIG_KEY_CORE_HOOKS_PATH, HOOKS_DIR)
	err = cmd2.Run()
	checkErr(err)
	// err = cmd3.Run()
	// checkErr(err)

	log.Println("exec git config --global ", GIT_CONFIG_KEY_CHECK_FILE, CHECK_STYLE_XML_LOCATION)
	err = cmd4.Run()
	checkErr(err)

	log.Println("exec git config --global ", GIT_CONFIG_KEY_CHECK_JAR, destCheckStyleJarPath)
	err = cmd5.Run()
	checkErr(err)
	log.Println("auto config complete")

	waitForInput()
}

func copyFile(srcFilePath, destFilePath string) {
	srcFile, err := os.Open(srcFilePath)
	checkErr(err)
	defer srcFile.Close()

	destFile, err := os.Create(destFilePath) // creates if file doesn't exist
	checkErr(err)
	defer destFile.Close()

	_, err = io.Copy(destFile, srcFile) // check first var for number of bytes copied
	checkErr(err)

	err = destFile.Sync()
	checkErr(err)
}

func checkErr(err error) {
	if err != nil {
		log.Printf("Error : %s \n", err)
		waitForInput()
	}
}

func waitForInput() {
	log.Println("Press Enter to exit!")
	input := bufio.NewScanner(os.Stdin)
	if input.Scan() {
		os.Exit(0)
	}
}

// CGO_ENABLED=0 GOOS=windows GOARCH=amd64 go build -o AutoConfig_win64.exe AutoConfig.go
// CGO_ENABLED=0 GOOS=windows GOARCH=386 go build -o AutoConfig_win32.exe AutoConfig.go
// go build -o AutoConfig_Mac AutoConfig.go
