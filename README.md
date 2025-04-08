
# 💳 계좌 관리 시스템 (Account Management System)

Spring Boot 기반의 계좌 관리 시스템으로, 계좌 생성부터 거래 처리, 예외 처리까지  
도메인 중심으로 설계된 실무 지향 백엔드 프로젝트입니다.

---

## 📌 주요 기능

- 🏦 계좌 관리
  - 고유한 계좌 번호 생성
  - 잔액 및 계좌 상태 관리

- 💸 거래 처리
  - 거래 요청 처리 및 잔액 업데이트
  - 유효성 검증 및 거래 내역 조회

- ⚠️ 에러 처리
  - 사용자 정의 예외 클래스 설계
  - 전역 예외 핸들러로 일관된 에러 응답 처리

- 🧱 도메인 기반 설계
  - 계층 구조 및 역할별 패키지 분리
  - AOP, DTO, Enum 활용

---

## 🧠 핵심 컴포넌트 설명

### 📌 Controller
- `AccountController` : 계좌 생성/조회 등 API 제공  
- `TransactionController` : 거래 요청/내역 관련 API 제공  

### 📌 Service
- `AccountService` : 계좌 관련 비즈니스 로직 처리  
- `TransactionService` : 거래 처리 및 동시성 제어 포함  

### 📌 DTO
- `AccountDto` : 계좌 응답용 데이터 모델  
- `TransactionDto` : 거래 응답용 모델  

### 📌 Repository
- `AccountRepository`  
- `AccountUserRepository`  
- `TransactionRepository`  

### 📌 AOP
- `AccountLock` : 거래 중 동시성 제어를 위한 AOP 락 처리

---

## 📁 프로젝트 구조
```
src
├── main
│   ├── java
│   │   └── com.example.account
│   │       ├── aop                # AOP 기반 락 처리
│   │       ├── config             # JPA, Redis 설정
│   │       ├── controller         # 계좌 및 거래 컨트롤러
│   │       ├── domain             # Entity 정의 (Account, User, Transaction)
│   │       ├── dto                # DTO (데이터 전송 객체)
│   │       ├── exception          # 예외 처리 모듈
│   │       ├── repository         # JPA 리포지토리
│   │       ├── service            # 비즈니스 로직
│   │       └── type               # Enum 정의 (상태, 에러 코드 등)
│   └── resources
│       ├── application.yml        # 설정 파일
│       ├── data.sql               # 초기 데이터
│       └── redis-server           # Redis 실행 파일
├── test
│   ├── controller                 # 컨트롤러 테스트
│   ├── service                    # 서비스 테스트
│   └── redis                      # Redis 관련 테스트
├── build.gradle
└── gradlew
```

---

## ⚙️ 실행 환경 및 요구 사항

| 항목         | 내용 |
|--------------|------|
| Java         | 11 이상 |
| Spring Boot  | 2.5 이상 |
| DB           | 기본: H2 (MySQL 등으로 교체 가능) |
| Redis        | 임베디드 Redis 사용 (M1 Mac에서 직접 빌드) |
| Build Tool   | Gradle 사용 |

---

## 🛠️ 향후 개선 예정

- ✅ Spring Security 기반 사용자 인증/인가 구현
- ✅ 감사 로그(Audit Log) 기능 추가
- ✅ 거래 리포트 및 통계 기능 강화

---

## 📬 문의

해당 프로젝트에 대한 문의 사항이 있거나 개선 제안이 있으시다면  
GitHub 이슈 또는 아래 이메일로 연락해 주세요:

📧 gleewithajoy@gmail.com
