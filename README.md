Image Explainer
===============

## 개요
- 시각장애인을 위한 앱입니다.
- 딥러닝 모델을 이용해 이미지에 대한 문장을 생성 후 음성으로 변환해서 사용자에게 들려주는 것이 주요 기능입니다.
- 사용자(시각장애인)가 앱을 실행하고 카메라 화면 중 아무 곳이나 탭하면 사진이 찍히고, 찍힌 사진에 대한 해설을 음성(영어)으로 들을 수 있도록 개발했습니다.

## 사용된 기술

1. Deep Learning - model im2txt
2. Android
3. Web Server - nodejs
4. TTS API

---
## 실행 방법

### Deep Learning

```
1. Repo clone - git clone
2. Install java 8
3. Install miniconda3 for virtual environment
4. Install bazel
5. Install pip, python version 3.5
6. conda create -n [name] python=3.5
7. source activate [name] in order for virtual environment
7. Install tensorflow 1.0
8. im2txt 폴더에 generate.sh 스크립트에 경로를 자신의 PC에 맞게 변경하고 실행해주세요.
9. 혹시 안된다면 new_checkpoint_saver.py를 실행하고 다시 스크립트를 실행해주세요.
```
혹시 잘 안되시면 Issue 생성 부탁드립니다.😅

### Web Server

1. npm install
2. npm start

### Android
```
Android OS version: 7.0 / API Level: 24
Permission: 카메라

1. Naver Developers에서 애플리케이션 등록
2. TTS.java의 CLIENT_ID와 CLIENT_SECRET을 자신의 Client ID와 Client Secret으로 변경
3. SendImage.java에서 SERVER_URL을 자신의 서버주소로 변경
```
---
## 참고
https://github.com/tensorflow/models

https://github.com/KranthiGV/Pretrained-Show-and-Tell-model
