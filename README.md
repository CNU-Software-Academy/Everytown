![file](https://github.com/CNU-Software-Academy/Everytown/assets/64695312/cc5708d3-c98c-44e4-bdc6-4e296605d116)# Everytown
동계 1팀

# 프로젝트 개요

## 충남대학교 온라인 메타버스 프로젝트 EveryTown

프론트엔드와 백엔드의 협력을 통해 실제 프로젝트를 구축하는 데에서 시작되었습니다. 프로젝트 주제는 신입생들 등 본교에 익숙하지 않은 유저들이 충남대학교를 온라인 상에서 미리 체험할 수 있는 서비스를 개발하는 것이었습니다.
사용자는 온라인 상에서 가상의 캐릭터를 움직여 교내를 탐험하고, 유용한 정보를 공유하고 확인할 수 있습니다.

# 기술 스택

## 백엔드 구축

- 스프링 부트를 이용한 백엔드 서비스 구축
- JPA를 활용하여 코드를 기반으로 MySQL 테이블 조작
- 3-tier Architecture을 구축하여 서비스에 맞는 API 설정
- 스프링 시큐리티를 이용한 JWT 인증 기반 시스템 구축

## 프론트엔드 개발

- JavaScript 프레임워크인 Phaser3를 활용하여 게임과 같은 서비스 구축
- Webpack을 이용한 프로젝트 번들링 및 파일 관리
- 백엔드와의 HTTP 통신 구현으로 서비스 작동

## 컨테이너화 및 배포

- Docker를 활용하여 컨테이너 상에서 서비스 실행
- 도커 이미지 빌드 및 docker-compose를 사용한 서비스 연결
- Nginx를 이용한 리버스 프록시 설정

## 클라우드 환경

- Naver Cloud Platform (NCP)의 VPC를 활용하여 서버 구축
- 서버 상에서 Docker를 설치하여 전체 시스템을 클라우드 Docker로 이전
- 공인 IP를 사용하여 사용자 접속 환경 구축
- *현재 ncp에는 접근 불가*

## 동적 파일 서버

- Express 기반 동적 파일 서버 구축
- 이미지 파일과 같은 DB에 저장하기 어려운 파일을 주고 받을 수 있는 서버 구현

## 아키텍쳐 구조

![file](https://github.com/CNU-Software-Academy/Everytown/assets/64695312/13cd53a3-a47f-479e-8893-7c13c7c620fd)

## 발표 동영상 링크

https://www.youtube.com/watch?v=NJjKQ80mFIg
