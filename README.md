# Image-Explainer [딥러닝으로 사진에 대한 문장 생성 --> 음성으로 변환]

### 개요
- 시각장애인을 위한 사진 해설 어플리케이션으로서 사용자(시각장애인)의 모바일에서 어플리케이션을 실행하고 카메라화면 아무데나 클릭을 하면 찍힌 사진에 대한 해설을 영어 음성으로 들을 수 있도록 개발하였습니다.
- Deep Learning(im2txt), Android, Web Server(nodejs), TTS API 등의 기술이 사용되었습니다.
- 안드로이드및 API 부분을 맡은 팀원과 함께 개발

---
### 실행 방법

#### Deep Learning

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
혹시 잘 안되시면 Issues 란에 글 남겨주세요.

#### Web Server
1. npm install
2. npm start

#### Android
```
Android OS version : 7.0 / API Level : 24
Permission : 카메라

1. Naver Developers에서 애플리케이션 등록
2. TTS.java의 CLIENT_ID와 CLIENT_SECRET을 자신의 Client ID와 Client Secret으로 변경
3. SendImage.java에서 SERVER_URL을 자신의 서버주소로 변경
```
---
## 참고
https://github.com/tensorflow/models

https://github.com/KranthiGV/Pretrained-Show-and-Tell-model
