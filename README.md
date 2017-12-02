# Image-Explainer [시각장애인을 위한 사진 해설 어플리케이션]

## 캡스톤 디자인 1
- 10 김진우: jinuman
- 14 정소현 : 정소현

## 개요
- 캡스톤 디자인1 프로젝트및 보고서 저장소입니다.
- 시각장애인을 위한 사진 해설 어플리케이션으로서 사용자(시각장애인)의 모바일에서 어플리케이션을 실행하고 카메라화면 아무데나 클릭을 하면 찍힌 사진에 대한 해설을 영어 음성으로 들을 수 있도록 개발하였습니다.
- 딥러닝, 안드로이드, 웹서버, TTS(API) 등을 이용하여 프로젝트를 진행하였습니다.
---
## 실행 방법
### 딥러닝
```
1. 이 저장소를 clone 해주세요.
2. java가 설치가 안되어 있다면 설치해주세요. 되도록이면 java 8로 설치해주세요.
3. bazel을 설치해주세요.
4. pip, python 버전 3.5를 설치해주세요.
5. miniconda3을 설치해주세요.
6. conda create -n [name] python=3.5 를 하고 source activate [name] 을 해서 conda 환경을 만들어주세요.
7. conda 환경에서 tensorflow 1.0 버전을 OS에 맞게 설치해주세요.
8. im2txt 폴더에서 git clone https://github.com/KranthiGV/Pretrained-Show-and-Tell-model.git 해주세요..(파일이 커서 그런지 이상하게 git add가 안되었습니다..)
9. https://github.com/KranthiGV/Pretrained-Show-and-Tell-model checkpoint file들을 다운로드 받아서 clone한 Pretrained-Show-and-Tell 폴더에 넣어주세요.
10. im2txt 폴더에 generate.sh 스크립트에 경로를 자신의 PC에 맞게 변경하고 실행해주세요.
11. 혹시 안된다면 new_checkpoint_saver.py를 실행하고 다시 스크립트를 실행해주세요.
```
혹시 잘 안되시면 *김진우contact : jin35kim@gmail.com* 이메일 보내주세요

### 웹서버
1. npm install
2. npm start

### 안드로이드

---
## 참고
https://github.com/tensorflow/models
https://github.com/KranthiGV/Pretrained-Show-and-Tell-model