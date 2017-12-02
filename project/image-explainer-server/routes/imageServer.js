var express = require('express');
var router = express.Router();
var exec = require("child_process").exec;
var fs = require('fs');

//이미지 저장되는 위치 설정
var path = require('path');
var uploadDir = path.join( __dirname , '../uploads/' );

var filename = 1;
//multer 셋팅
var multer  = require('multer');
var upload = multer({
    dest: uploadDir
});

router.get('/', function (req, res) {
    res.render('imageServer');
});

router.post('/api/photo', function (req, res) {

    // if (done == true){
    // console.log(req.files); // undefined?? ajax라서
    var dst = path.join(uploadDir, filename++ + ".jpeg"); // IMAGE_FILE 경로
    var ws =  fs.createWriteStream(dst, {encoding: 'binary'});
    req.pipe(ws);
    ws.on("finish", function() {
        console.log('이미지 전송 완료 -> 텍스트로 변환');
        console.log('경로 : ' + dst);
        exec("sh generate.sh " + dst, function (err, stdout, stderr) {

            //Print stdout/stderr to console
            console.log('########## Predicting Start .. ##########\n');
            console.log(stderr);
            console.log('Result : ' + stdout);

            //Simple response to user whenever localhost:3000 is accessed
            //res.render('cmd', { title: 'ML-Result', data: stdout });
            console.log('########## Process End ! ##########');
            res.send(stdout);  // data 로 넘어간다.
        });
    });
    // }

});

module.exports = router;