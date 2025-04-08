# 💳 계좌 관리 시스템 (Account Management System)

Spring Boot 기반의 **계좌 관리 시스템**으로, 계좌 생성부터 거래 처리, 예외 처리까지 도메인 중심으로 설계된 프로젝트입니다.  
확장성과 유지보수성을 고려하여 **AOP, DTO, JPA, Redis** 등을 활용해 구성했습니다.

---

## 🧩 프로젝트 주요 기능

### ✅ 계좌 관리
- 고유 계좌번호로 새로운 계좌 생성
- 계좌 상태 및 잔액 관리

### 💸 거래 처리
- 거래 요청 처리 및 잔액 업데이트
- 거래 내역 조회 기능
- 유효성 검증 포함

### ⚠️ 에러 및 예외 처리
- 사용자 정의 예외 클래스
- 중앙 집중형 에러 핸들링 (`@ControllerAdvice`)

### 🧱 도메인 기반 설계
- 실무 구조에 가까운 패키지 분리
- DTO, AOP, Enum 기반 확장성 확보

---

## 🏗️ 프로젝트 구조

```plaintext
src
├── main
│   ├── java
│   │   └── com.example.account
│   │       ├── aop                # AOP 기반 락 처리
│   │       ├── config             # JPA, Redis 설정
│   │       ├── controller         # 계좌 및 거래 컨트롤러
│   │       ├── domain             # Entity 정의 (Account, User, Transaction)
│   │       ├── dto                # 데이터 전송 객체 (DTO)
│   │       ├── exception          # 예외 처리 모듈
│   │       ├── repository         # JPA 리포지토리
│   │       ├── service            # 핵심 비즈니스 로직
│   │       └── type               # Enum 타입 정의 (계좌 상태, 에러 코드 등)
│   └── resources
│       ├── application.yml        # 설정 파일
│       ├── data.sql               # 초기 데이터
│       └── redis-server           # Redis 실행 파일 (임베디드)
├── test
│   ├── controller                 # 컨트롤러 테스트
│   ├── service                    # 서비스 테스트
│   └── redis                      # Redis 관련 테스트
├── build.gradle
└── gradlew
