# spring-web-starter

## 미들웨어
### 개념
> 미들웨어에서 미들(Middle)과 소프트웨어(Software)의 합성어로 미들웨어는 표준화된 인터페이스를 제공하며 복잡한 분산 시스템에서 
> 이기종간에 통신 및 데이터 관리 등 가능하게 통합 관리해주는 역할이다.  
> * 표준화된 인터페이스 제공 기능
> * 다양한 환경 지원, 체계가 다른 업무와 상호 연동이 가능
> * 분산된 업무를 동시에 처리 가능하여 자료의 일관성이 유지
> * 부하의 분산이 가능
> 통상적으로 기업에서 말하는 미들웨어 환경은 웹/어플리케이션 서버를 의미한다.
>
> DBMS를 직접 클라이언트가 연결되어 동작하는 방식이 여러 가지 단점이 있었음을 알게 된 후 이러한 문제점을 해결하기 위해 등장한것이 미들웨어라는 개념이다. 
> 클라이언트와 DBMS사이에 위의 그림과 같이 또 다른 서버를 두는 방식이다.   
> 클라이언트는 단순히 요청만 중앙에 있는 서버에게 보내고, 중앙에 있는 서버(미들웨어)는 대부분의 로직을 수행한다.   
> 이때, 데이터를 조작할 일이 있으면 DBMS에게 부탁한다.  

### WAS 주요기능
> * 프로그래밍 실행환경과 데이버베이스 접속 기능을 제공.
> * 여러개의 트랜잭션을 관리.
> * 업무를 처리하는 비즈니스 로직을 수행  
> 
> 이 외에도 WAS는 기본적으로 웹서버의 기능도 제공한다.  
> 그래서 웹서버 따로 WAS 따로 설치안하고 톰캣이라는 WAS하나만 설치하고 이용이 가능한 이유는 이 WAS, 톰캣이 가지고 있는 웹서버가 
> 충분한 기능을 하고 있기 때문에 굳이 따로 Apache같은 웹서버를 같이 설치 안하고 톰캣만 설치해서 사용하는 것임.  
> 
> 사실 웹서버 없이 WAS만 있어도 정적인 콘텐츠와 동적인 콘텐츠를 모두 제공할 수 있음.  
> WAS 등장이 초창기였을 때에는 WAS에 내장된 웹서버가 성능이 좀 떨어졌음. 
> 그랬기 때문에 초창기에는 웹어플리케이션을 실행할 때, Apache와 톰캣을 같이 설치해서 실행을 했어야 됐는데, 
> 이게 계속 발전하면서 웹 서버의 역할도 충분히 해주고 있기 때문에 웹 서버를 따로 설치하지 않아도 충분히 동작하는 경우들이 굉장히 많아짐.  
> 
> 그럼에도 불구하고 웹서버가 WAS 앞단에 있으면 좋은 이유는 있음.  
> 웹서버는 상대적으로 WAS보다 간단한 구조로 만들어져 있음. 사람들이 많이 접속하는 대용량 웹어플리케이션의 경우에는 서버의 수가 여러대 일수 있음. 
> 가끔 프로그램이 혼자 종료되는 경우 있지않음? WAS에서 동작하도록 개발자가 만든 프로그램이 오작동이 발생해서 WAS 자체에 문제가 발생하는 경우도 있음. 
> 이 경우, WAS를 재시작해야 하는 경우가 생기는데, 문제가 있는 WAS를 재 시작할 때 앞단의 웹 서버에서 먼저 해당 WAS를 이용하지 못하도록 하고 
> WAS를 재시작한다면 해당 웹 애플리케이션을 사용하는 사람은 WAS의 문제가 발생한지 모르고 이용할 수 있을 것임. 
> 이러한 처리를 장애극복기능 이라고 함.  
> 대용량 웹애플리케이션에는 무중단으로 운영하기 위해서 상당히 중요한기능임. 이러한 기능 때문에 보통 웹서버가 WAS앞단에 동작하도록 하는 경우가 많음.  
> 즉 정리하자면,
> * 규모가 커질수록 웹 서버와 WAS를 분리합니다.  
> * 자원 이용의 효율성 및 장애 극복, 배포 및 유지보수의 편의성을 위해 웹서버와 WAS를 대체로 분리합니다.  

### 참조사이트
> [[WEB] 미들웨어란?](https://linked2ev.github.io/devlog/2022/01/26/WEB-%EB%AF%B8%EB%93%A4%EC%9B%A8%EC%96%B4%EB%9E%80/)  
> [[인프라 뿌시기 #1] 미들웨어, 개념을 알아보자](https://velog.io/@unyoi/%EC%9D%B8%ED%94%84%EB%9D%BC-%EB%BF%8C%EC%8B%9C%EA%B8%B01-%EB%AF%B8%EB%93%A4%EC%9B%A8%EC%96%B4-%EA%B0%9C%EB%85%90%EC%9D%84-%EC%95%8C%EC%95%84%EB%B3%B4%EC%9E%90)  

---

## Apache Tomcat
### 웹 서버(Web server)와 웹 애플리케이션 서버(WAS)
> **웹 서버**  
> 클라이언트에서 요청하는 HTTP요청을 처리하는 서버를 의미한다. 이는 정적타입(HTML, CSS, 이미지 등)의 데이터만을 처리한다.
> 
> **웹 애플리케이션 서버(WAS)**  
> 사용자와 상호작용하는 동적인 페이지를 제공하는 서버.     
> 동적인 페이지 제공을 위한 웹 서비스 처리 및 데이터베이스 연결을 통해서 고객 데이터를 관리 및 유지한다.      
> 기본적으로 사용되는 기능 3가지는 아래와 같다.    
> * 프로그램 실행 환경과 데이터베이스 접속 기능을 제공한다.  
> * 여러 개의 트랜잭션을 관리한다.  
> * 업무를 처리하는 비즈니스 로직을 수행한다.  

### 톰캣
> 톰캣은 웹 애플리케이션 서버(WAS)를 제공하기 위한 컨테이너이다.   
> JAVA EE 기반으로 만들어졌으며, JSP 와 Servlet 을 구동하기 위한 서블릿 컨테이너 역할을 수행한다.  
> 웹 서버와는 다르게 DB 연결, 다른 응용프로그램과 상호 작용 등 동적인 기능들을 사용할 수 있다.  

### application.yml
> 기본 값은 다음 클래스에서 확인 가능: `org.springframework.boot.autoconfigure.web.ServerProperties`  
> 
> **Connection 관련**  
> `server.tomcat.connection-timeout`: 커넥션 타임아웃 설정, 기본값은 없다.    
> `server.tomcat.keep-alive-timeout`: 커넥션 종료 전 다른 HTTP 요청을 기다리는 시간 설정. 설정하지 않으면 connection-timeout 이 사용, 
> -1 이면 무한.  
> `server.tomcat.max-connections`: 서버가 주어진 시간에 처리할 수 있는 최대 커넥션 설정. 기본값은 8192.  
> 
> **Thread 관련**  
> `server.tomcat.threads.max`: 최대 스레드 설정. 기본값은 200.  
> `server.tomcat.threads.min-spare`: 최소 여유 스레드 설정. 기본값은 10.  
> `server.tomcat.accept-count`: 가능한 모든 요청 처리 스레드가 사용 중일 때 들어오는 연결 요청의 최대 큐 길이 설정. 기본값은 100.  
> 
> **Cache 관련**  
> `server.tomcat.processor-cache`: 캐시에 재사용될 프로세서 수 설정, -1 설정 시 max-connections 과 동일한 이론적 최대 크기로 설정됨. 기본값은 200.    
> `server.tomcat.resource.allow-caching`: 어플리케이션 정적 리소스 캐싱 허용여부. 기본값은 true.  
> `server.tomcat.resource.cache-ttl`: 정적 리소스 캐시의 유지시간(Time-to_live). 기본값은 없음.    
> 
> **Request 관련**  
> `server.tomcat.max-http-form-post-size`: HTTP Post 요청의 최대 form size. 기본값은 2MB.  
> `server.tomcat.max-swallow-size`: request body의 최대 수용 크기. 기본값은 2MB.  
> `server.tomcat.redirect-context-root`: 컨텍스트 루트 경로에 /를 추가해서 리다이렉션 해야되는지 설정. 프록시에서 종료된 SSL을 사용하는 경우 false로 설정해야 됨. 기본값은 true.  
> `server.tomcat.use-relative-redirects`: sendRedirect 호출에 의해 생성된 HTTP 1.1 혹은 그 이후 헤더가 상대/절대 리다이렉션을 사용할지 여부. http에서 http로 리다이렉트 되는 경우 true로 설정. 기본값은 false.  
> `server.tomcat.reject-illegal-header`: 잘못된 헤더 이름이나 값을 갖는 request를 거부할지 여부. 기본값은 true.  
> `server.tomcat.additional-tld-skip-patterns`: TLD(Tag Library Descriptor : JSP에서 사용되는 커스텀 태그 나 JSTL태그 설정파일) 제외 패턴 설정. 기본값은 없음.  
> `server.tomcat.relaxed-path-chars`: URI 경로에 포함되어야하는 콤마로 구분된 문자 목록. "<>[\](^'{|}" 만 허용. 기본값은 없음.  
> `server.tomcat.relaxed-query-chars`: URL 쿼리에 포함되어야하는 콤마로 구분된 문자 목록. "<>[\](^'{|}" 만 허용. 기본값은 없음.  
> `server.tomcat.uri-encoding`: URI 인코딩 설정. 기본값은 UTF-8.  
> 
> **Remoteip 관련**  
> `server.tomcat.remoteip.host-header`: 원격 호스트에서 추출된 HTTP 헤더의 이름. 기본값은 X-Forwarded-Host.  
> `server.tomcat.remoteip.internal-proxies`: 신뢰할 수 있는 프록시와 일치하는 정규식. 기본값은 없음.  
> `server.tomcat.remoteip.port-header`: 기본 포트 값을 override 하는데 사용되는 HTTP header의 이름. 기본값은 X-Forwarded-Port.  
> `server.tomcat.remoteip.protocol-header`: 들어오는 프로토콜을 유지하는 헤더로, X-Forwarded-Proto 가 지정됨. 기본값은 없음.  
> `server.tomcat.remoteip.protocol-header-https-value`: 들어오는 요청이 SSL을 사용하는지 여부를 나타내는 프로토콜 헤더의 값. 기본값은 https.  
> `server.tomcat.remoteip.remote-ip-header`: 원격 IP가 추출되는 HTTP 헤더의 이름. 기본값은 X-FORWARDED-FOR.  
> 
> **AccessLog 관련**  
> `server.tomcat.accesslog.buffered`: 주기적으로 접속로그의 출력 버퍼를 플러시 할지 설정. 기본값은 true.  
> `server.tomcat.accesslog.check-exists`: 접속로그의 이름이 바뀐경우 파일이 존재하는 지 확인 여부. 기본값은 false  
> `server.tomcat.accesslog.condition-if`: request.getAttribute("attribute name") 이 null이 아닐 경우만 로깅. 기본값은 없음.  
> `server.tomcat.accesslog.condition-unless`: request.getAttribute("attribute name") 이 null일 경우만 로깅. 기본값은 없음.  
> `server.tomcat.accesslog.directory`: 로그 파일이 생성되는 경로 설정. 기본값은 같은 디렉토리의 logs.  
> `server.tomcat.accesslog.enabled`: 접속로그 활성화 여부. 기본값은 false.  
> `server.tomcat.accesslog.encoding`: 로그파일 케릭터셋 설정. 기본값은 시스템 케릭터셋.  
> `server.tomcat.accesslog.file-date-format`: 로그파일 이름의 날짜 형식 설정. 기본값은 `.yyyy-mm-dd`.  
> `server.tomcat.accesslog.ipv6-canonical`: RFC 5952에 정의된 IPv6 표준 표현 형식을 사용할지 여부. 기본값은 false.  
> `server.tomcat.accesslog.locale`: 로그에 사용되는 timesamp locale(언어, 지역 설정, 출력 형식 등을 정의하는 문자열) 접미사. 기본값은 없음.  
> `server.tomcat.accesslog.max-days`: 접속 로그 보관 기간 설정. 기본값은 -1.  
> `server.tomcat.accesslog.pattern`: 접속 로그 패턴 설정. 기본값은 `common`.  
> `server.tomcat.accesslog.prefix`: 접속 로그 접두사 설정. 기본값은 `access_log`.  
> `server.tomcat.accesslog.suffix`: 접속 로그 접미사 설정 기본값은 `.log`.  
> `server.tomcat.accesslog.rename-on-rotate`: 접속 로그 로테이션 전까지 날짜를 포함하지 않을지 여부. 기본값은 false.  
> `server.tomcat.accesslog.request-attributes-enabled`: request의 attribute에 IP주소, 호스트명, 프로토콜, 포트 정보를 설정할지 여부. 기본값은 false.  
> `server.tomcat.accesslog.rotate`: 접속 로그의 rotation 여부. 기본값은 true.  
> 
> **기타**  
> `server.tomcat.basedir`: 톰캣 기본 디렉토리 설정. 기본값은 없음.  
> `server.tomcat.background-processor-delay`: 백그라운드 프로세스 호출 사이의 딜레이 설정. 시간 접미사를 쓰지 않으면 초로 사용 (초:s, 분:m..). 기본값은 10s.  
> `server.tomcat.mbeanregistry.enabled`: mBean(Managed Bean) Registry 활성화 여부. 기본값은 false.  
> 
> **참조사이트**  
> [Spring Boot Embeded Tomcat 내장 톰캣 application.properties 설정](https://aljjabaegi.tistory.com/601)  

---

## WebConfig
### Configuration class
> 웹에 관한 설정은 @Configuration 클래스에 WebMvcConfigurer 인터페이스를 구현하여 설정한다.  
> 필요한 웹 설정을 적절히 Override 하여 설정한다.  
> WebConfig.java
> ```java
> @Configuration
> public class WebConfig implements WebMvcConfigurer {
>   ...
> }
> ```

### Static resources
> application.yml
> ```yaml
> spring:
>   web:
>       resources:
>           static-locations: classpath:/static, classpath:/test-static
> ```
> 위의 설정 시 src/resources/static 및 src/resources/test-static 에 있는 파일에 대해 외부 접근이 가능하다.    
> 예를 들어 static 디렉터리 아래 test.txt 파일을 외부에서 접근하려하면 다음과 같이 접근하면 된다.  
> `http://localhost:8080/test.txt`: 포트 뒤 경로에 /static 이 없어도 된다.  
> 디폴트 값으로 classpath:/static 으로 되어 있으므로 만약 src/resources/static 디렉터리 경로에 외부 접근 파일을
> 둔다면 따로 application.yml 설정을 건들 필요 없다.
>
> WebConfig.java
> ```java
> @Configuration
> public class WebConfig implements WebMvcConfigurer {
>    ...
>    @Override
>    public void addResourceHandlers(ResourceHandlerRegistry registry) {
>        registry.addResourceHandler("/static/**")
>                .addResourceLocations("classpath:/static/")
>                .setCachePeriod(0);     // 0은 캐시를 사용 안한다는 설정이다.
>    }
> }
> ```
> `spring.web.resources.static-locations` 설정은 uri 에 /static 이 붙지 않는 경로를 설정하는 것이지만
> 위의 WebConfig 에서 `ResourceHandlerRegistry` 를 통한 설정은 uri 설정 및 설정한 uri 에 맵핑되는 리소스 위치 경로를
> 지정한다. 또한 캐시 설정도 가능하다.

### CORS Settings
> CorsRegistry 객체를 이용하여 CORS 를 적용할 도메인 설정 및 설정한 도메인의 접속을 허용할 출처를 설정할 수 있다.  
> 브라우저를 통한 API 호출의 경우 CORS 설정이 반드시 필요하며, 브라우저가 아닌 모바일 앱에서 API 를 호출하는 경우에는
> 필요하지 않을 것으로 예상된다.(CORS 는 브라우저에서 동작하기 때문에)  
> WebConfig.java
> ```java
> @Configuration
> public class WebConfig implements WebMvcConfigurer {
>    ...
>    @Override
>    public void addCorsMappings(CorsRegistry registry) {
>        registry.addMapping("/**")     // 도메인 설정
>                .allowedOrigins("*");  // 설정한 도메인의 접속을 허용할 출처 설정
>    }  
> }
> ```

---

## ObjectMapper(Jackson)
### JavaTimeModule
> POST, PUT, DELETE 와 같이 Request body 를 담은 요청에서 문자열로 표현된 날짜를
> LocalDate, LocalDateTime 으로 직렬화해주는 모듈이다.  
> jackson-datatype-jsr310 라이브러리에 포함되어 있다.
>
> RFC 3339 포맷의 문자열을 ZonedDateTime 으로 직렬화(json -> dto), 역직렬화(dto -> json) 설정 코드
> ```java
> @Configuration
> public class JacksonConfig {
> 
>     public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
> 
>     @Bean
>     @Primary
>     public ObjectMapper serializingObjectMapper() {
>         ObjectMapper objectMapper = new ObjectMapper();
>         objectMapper.registerModule(javaTimeModule());
>         return objectMapper;
>     }
>     
>     private JavaTimeModule javaTimeModule() {
>         JavaTimeModule javaTimeModule = new JavaTimeModule();
>         javaTimeModule.addSerializer(ZonedDateTime.class, new ZonedDateTimeSerializer());
>         javaTimeModule.addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer());
>         return javaTimeModule;
>     }
> 
>     static class ZonedDateTimeTimeSerializer extends JsonSerializer<ZonedDateTime> {
>         @Override
>         public void serialize(ZonedDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
>             gen.writeString(value.format(FORMATTER));
>         }
>     }
> 
>     static class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {
>         @Override
>         public ZonedDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
>             return ZonedDateTime.parse(p.getValueAsString(), FORMATTER);
>         }
>     }
> }
> ```

### [Custom] TrimStringModule
> 앞뒤 공백이 있는 문자열의 공백을 없애서 직렬화(json -> dto), 역직렬화(dto -> json)  
> 모든 데이터가 trim 을 필요로하지는 않는다. 예를 들면 텍스트 메시지와 같은 것들은 앞뒤 공백을 제거할지 안할지는 논의가 필요한 부분이다.  
> 즉 TrimStringModule 의 경우 필수가 아닌 논의를 통해서 선택해야할 사항이다.  
> ```java
> @Configuration
> public class JacksonConfiguration {
> 
>     @Bean
>     @Primary
>     public ObjectMapper serializingObjectMapper() {
>         ObjectMapper objectMapper = new ObjectMapper();
>         objectMapper.registerModule(trimStringModule());
>         return objectMapper;
>     }
>     
>     private TrimStringModule trimStringModule() {
>         TrimStringModule trimStringModule = new TrimStringModule();
>         trimStringModule.addSerializer(String.class, new TrimStringSerializer());
>         trimStringModule.addDeserializer(String.class, new TrimStringDeserializer());
>         return trimStringModule;
>     }
>       
>     static class TrimStringModule extends SimpleModule {
>     }
>     
>     static class TrimStringSerializer extends JsonSerializer<String> {
>         @Override
>         public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
>             gen.writeString(value.trim());
>         }
>     }
>     
>     static class TrimStringDeserializer extends JsonDeserializer<String> {
>         @Override
>         public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
>             return p.getValueAsString().trim();
>         }
>     }
> }
> ```

### JSON attribute 표현을 CamelCase 에서 snake_case 로 변환
> 기본적으로 스프링은 jackson 을 사용하기 때문에 application.yml 에 해당 설정을 추가한다.  
> ```yaml
> spring:
>     jackson:
>         property-naming-strategy: SNAKE_CASE
> ```
> 그러면 Controller 에서 응답 시 기존 Java 클래스에 CamelCase 로 작성했던 필드들이 스프링 내부의 Jackson 을 통해서 snake_case 로 표시된다.  
> 
> 만약 ObjectMapper 를 @Bean 으로 등록한 경우 application.yml 의 설정이 적용되지 않는다. Jackson 내부적으로 @Bean 으로 등록된 ObjectMapper 를 
> 사용하는 것 같다. 그래서 자체적으로 ObjectMapper 를 빈으로 등록하면 Jackson 에서 해당 ObjectMapper 를 보게 된다.  
> 무튼 이런 경우 ObjectMapper 에 다음과 같이 설정을 추가한다.  
> ```java
> @Bean
> @Primary
> public ObjectMapper serializingObjectMapper() {
>     ObjectMapper objectMapper = new ObjectMapper();
>     ...
>     objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
>     return objectMapper;
> }
> ```
> 
> **참조사이트**  
> [Snake-Case Parameters in Spring Boot REST Controllers](https://www.beyondjava.net/spring-boot-snake-case)
> [[Java] Jackson 프로퍼티명 snake_case <-> camelCase 변환](https://umbum.dev/1140)  
> 

### 참조사이트
> [[JAVA] 자바 날짜 포맷 변경 방법(SimpleDateFormat) yyyyMMdd](https://junghn.tistory.com/entry/JAVA-자바-날짜-포맷-변경-방법SimpleDateFormat-yyyyMMdd)
> [Jackson으로-LocalDate-자동-매핑하기](https://velog.io/@recordsbeat/Jackson%EC%9C%BC%EB%A1%9C-LocalDate-%EC%9E%90%EB%8F%99-%EB%A7%A4%ED%95%91%ED%95%98%EA%B8%B0)

---

## Paging
### org.springframework.data.domain.Pageable
> Controller 의 메서드에서 ArgumentResolver 를 통해서 Pageable 객체를 매개변수로 받을 수 있다.  
> Pageable 객체로 맵핑되는 query parameter 로는 `page`, `size`, `sort` 가 있다.
>
> `page`: 페이지 번호(0부터 시작)  
> `size`: 한 페이지에서 항목의 갯수(default: 20)  
> `sort`: 정렬, 예를 들어 name 컬럼을 내림차순으로 정렬하고 싶다 => `sort=name,desc`

### application.yml
> `spring.data.web.pageable.default-page-size`: default 페이지 사이즈 갯수 설정(default: 20)  
> `spring.data.web.pageable.one-indexed-parameters`: 시작 페이지를 1로할지 여부(default: false)

### PageRequest
> Pageable 인터페이스를 구현한 객체가 `PageRequest` 이며 테스트 시 `PageRequest.of(int page, int size, Sort sort)` 메서드를 통해서 Pageable 객체를 생성한다.

### org.springframework.data.domain.Sort
> PageRequest 객체 생성 시 정렬 정보 전달을 위한 객체.  
> 예시: `Sort orderDateSort = Sort.by("orderDateUTC").descending();`

### @PageableDefault
> Page 를 GET 하는 API 호출 시 Pageable 과 관련된 query parameter 를 입력하지 않을 시 자동으로 Pageable 객체에 값을 채워주기 위한 애노테이션.  
> Pageable 객체가 선언된 매개변수 앞에 애노테이션을 붙인다.  
> 예시: `@PageableDefault(page = 0, size = 20, sort = "orderDateUTC,desc")`

### org.springframework.data.domain.Page
> page는 조회쿼리 이후 전체 데이터 갯수를 한번더 조회하는 카운트 쿼리가 실행된다.  
> `getTotalElements()`: 전체 데이터의 갯수이다.  
> `getTotalPages()`: 전체 페이지의 갯수이다.   

### org.springframework.data.domain.Slice
> slice는 카운트쿼리가 나가지 않고 다음 slice가 존재하는지 여부만 확인할 수 있기때문에, 데이터 양이 많으면 많을수록 slice를 사용하는것이 성능상 유리하다.  
> page는 게시판과 같이 총 데이터 갯수가 필요한 환경에서, slice는 모바일과 같이 총 데이터 갯수가 필요없는 환경에서(무한스크롤 등) 각각 필요한 용도에 알맞게 쓰면된다.  
> `getNumber()`: 현재 페이지  
> `getSize()`: 페이지 크기  
> `getNumberOfElements()`: 현재 페이지에 조회한 데이터 개수  
> `getContent()`: 현재 페이지에 조회한 데이터  
> `hasContent()`: 현재 페이지에 데이터가 있는지 여부  
> `getSort()`: 정렬 여부  
> `isFirst()`: 첫 번째 페이지인지 여부  
> `isLast()`: 마지막 페이지인지 여부  
> `hasNext()`: 다음 페이지가 있는지 여부  
> `hasPrevious()`:  이전 페이지가 있는지 여부  

### 참조사이트
> [Spring Pagination과 Page 그리고 Pageable](https://velog.io/@albaneo0724/Spring-Pagination과-Page-그리고-Pageable)  
> [Spring Data JPA의 Page와 Slice](https://zayson.tistory.com/entry/Spring-Data-JPA%EC%9D%98-Page%EC%99%80-Slice)  

---

## ArgumentResolver
### 개요
> 어떠한 요청이 컨트롤러에 들어왔을 때, 요청에 들어온 값으로부터 원하는 객체를 만들어내는 일을 ArgumentResolver 가 간접적으로 해줄 수 있다.  

### 구현
> ArgumentResolver는 HandlerMethodArgumentResolver 를 구현함으로써 시작된다.  
> ```java
> public interface HandlerMethodArgumentResolver {
> 
> 	boolean supportsParameter(MethodParameter parameter);
> 
> 	@Nullable
> 	Object resolveArgument(MethodParameter parameter, @Nullable ModelAndViewContainer mavContainer,
> 			NativeWebRequest webRequest, @Nullable WebDataBinderFactory binderFactory) throws Exception;
> }
> ```
> 우리는 원하는 ArgumentResolver가 실행되길 원하는 Parameter의 앞에 특정 어노테이션을 생성해 붙인다.  
> supportsParameter는 요청받은 메서드의 인자에 원하는 어노테이션이 붙어있는지 확인하고 원하는 어노테이션을 포함하고 있으면 true를 반환한다.  
> resolveArgument는 supportsParameter에서 true를 받은 경우, 즉, 특정 어노테이션이 붙어있는 어느 메서드가 있는 경우 parameter가 원하는 형태로 정보를 바인딩하여 반환하는 메서드이다.

### 예시
> `GET /` 요청에 Authorization 헤더 값을 담아서 요청하면 Controller 의 메서드에 `@Authenticated` 애노테이션이 붙은 파라미터에 헤더 값을 바인딩한다.  
> AuthorizationArgumentResolver.java
> ```java
> public class AuthorizationArgumentResolver implements HandlerMethodArgumentResolver {
>     @Override
>     public boolean supportsParameter(MethodParameter parameter) {
>         return parameter.getParameterType().equals(String.class)      // Controller 의 메서드에 선언된 파라미터의 선언 타입이 String 이면서
>                 && parameter.hasParameterAnnotation(Authenticated.class); // @Authenticated 애노테이션이 붙어있어야 파라미터로 바인딩한다.
>     }
> 
>     @Override
>     public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
>         HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();  
>         return request.getHeader(AUTHORIZATION);  // request 에서 Authorization 헤더값을 리턴한다.
>     }
> }
> ```
> Authenticated.java
> ```java
> @Target(ElementType.PARAMETER)
> @Retention(RetentionPolicy.RUNTIME)
> public @interface Authenticated {
> }
> ```
> WebConfig.java: ArgumentResolver 추가
> ```java
> @Configuration
> public class WebConfig implements WebMvcConfigurer {
>     @Override
>     public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
>         resolvers.add(new AuthorizationArgumentResolver());
>     }
> }
> ```
> HomeController.java
> ```java
> ...
> @GetMapping("/")
> public String getHome(@Authenticated String authentication) {
>     return authentication;
> }
> ...
> ```

### 예시 2 - 커스텀 PageRequest
> PageRequest.java
> ```java
> @Getter
> @ToString
> public class PageRequest {
>     public static final int DEFAULT_COUNT = 10;
>     public static final int DEFAULT_START_INDEX = 0;
> 
>     private final int count;
> 
>     private final int startIndex;
> 
>     private final PageSort sortBy;
> 
>     public PageRequest(int count, int startIndex, PageSort sortBy) {
>         validateCount(count);
>         validateIndex(startIndex);
> 
>         this.count = count;
>         this.startIndex = startIndex;
>         this.sortBy = sortBy;
>     }
> 
>     public static PageRequest of(int count, int startIndex, PageSort pageSort) {
>         return new PageRequest(count, startIndex, pageSort);
>     }
> 
>     public static PageRequest of(int count, int startIndex) {
>         return new PageRequest(count, startIndex, PageSort.noSort());
>     }
> 
>     public static PageRequest getDefault() {
>         return new PageRequest(DEFAULT_COUNT, DEFAULT_START_INDEX, PageSort.noSort());
>     }
> 
>     private void validateCount(int count) {
>         if (!(count >= 1 && count <= 100)) {
>             throw new IllegalArgumentException("PageRequest.count");
>         }
>     }
> 
>     private void validateIndex(int startIndex) {
>         if (startIndex < 0) {
>             throw new IllegalArgumentException("PageRequest.startIndex");
>         }
>     }
> }
> ```
> 
> PageRequestArgumentResolver.java  
> `supportsParameter` 메서드로 Controller 에서 매개변수로 PageRequest 클래스가 오면 해당 Argument Resolver 의 
> `resolveArgument` 메서드를 실행한다.    
> ```java
> public class PageRequestArgumentResolver implements HandlerMethodArgumentResolver {
>     @Override
>     public boolean supportsParameter(MethodParameter parameter) {
>         return parameter.getParameterType().equals(PageRequest.class);
>     }
> 
>     @Override
>     public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
>                                   NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
>         int count = getCount(webRequest);
>         int startIndex = getStartIndex(webRequest);
>         PageSort pageSort = getPageSort(webRequest);
>         if (pageSort == null) {
>             return PageRequest.of(count, startIndex);
>         }
>         return PageRequest.of(count, startIndex, pageSort);
>     }
> 
>     private int getCount(NativeWebRequest webRequest) {
>         String[] counts = webRequest.getParameterMap().get("count");
>         return counts == null ? PageRequest.DEFAULT_COUNT : Integer.parseInt(counts[0]);
>     }
> 
>     private int getStartIndex(NativeWebRequest webRequest) {
>         String[] startIndices = webRequest.getParameterMap().get("start_index");
>         return startIndices == null ? PageRequest.DEFAULT_START_INDEX : Integer.parseInt(startIndices[0]);
>     }
> 
>     private PageSort getPageSort(NativeWebRequest webRequest) {
>         String[] sortBies = webRequest.getParameterMap().get("sort_by");
>         if (sortBies == null) {
>             return PageSort.noSort();
>         }
> 
>         StringTokenizer tokenizer = new StringTokenizer(sortBies[0], ",");
>         String sortKey = tokenizer.nextToken();
>         String sortValue = tokenizer.nextToken();
> 
>         return PageSort.of(sortKey, Sorts.getMatchingSorts(sortValue));
>     }
> }
> ```

---

## Interceptor
### 개요
> 스프링 MVC 에서 인터셉터는 웹 애플리케이션 내에서 특정한 URI 호출을 말 그대로 '가로채는' 역할을 합니다.  
> 인터셉터를 활용하면 기존 컨트롤러의 로직을 수정하지 않고도, 사전이나 사후에 제어가 가능합니다.  
> 쉽게 말해, 요청과 응답을 가로채서 원하는 동작을 추가하는 역할입니다.  
> 
> 예를 들자면, 세션을 통한 인증을 쉽게 구현할 수 있습니다(Spring Security 를 쓰지 않는다는 가정하에).  
> 요청을 받아 들이기 전, 세션에서 로그인한 사용자가 있는지 확인해보고 없다면 로그인 페이지로 redirect 시킬 수 있죠.  
> Interceptor가 없다면 모든 컨트롤러마다 해당 로직을 넣어야 하니, 꽤나 번거롭고 비효율적입니다.  
> 
> **Filter 와 공통점**  
> Servlet 기술의 Filter와 Spring MVC의 HandlerInterceptor는 특정 URI에 접근할 때 제어하는 용도로 사용된다는 공통점을 가지고 있습니다.   
> 
> **Filter 와 차이점**  
> Filter는 동일한 웹 애플리케이션의 영역 내에서 필요한 자원들을 활용합니다.  
> 웹 애플리케이션 내에서 동작하므로, 스프링의 Context를 접근하기 어렵습니다.  
> Interceptor의 경우 스프링에서 관리되기 때문에 스프링 내의 모든 객체(빈)에 접근이 가능하다는 차이가 있습니다.  
> 즉, 빈을 관리하는 스프링 컨텍스트 내에 있어서 생성된 빈들에 자유롭게 접근할 수 있습니다.  
> 
> **Filter 와 용도 처이**  
> Filter  
> 보안 관련 공통 작업, 모든 요청에 대한 로깅 또는 감사, 이미지/데이터 압축 및 문자열 인코딩  
> 
> Interceptor  
> 인증/인가 등과 같은 공통 작업, Controller로 넘겨주는 정보의 가공, API 호출에 대한 로깅 또는 감사  

### HandlerInterceptor
> **preHandle**  
> `boolean preHandle(request, response, handler)`: preHandle 메서드는 지정된 컨트롤러의 동작 이전에 가로채는 역할로 사용합니다.    
> 메서드의 반환값이 true이면 핸들러의 다음 동작이 실행되지만 false이면 중단되어서 남은 인터셉터와 컨트롤러가 실행되지 않습니다.  
>
> 현재 실행되는 컨트롤러와 메소드의 정보를 파악하는 예제
> ```java
> @Override
> public boolean preHandle(HttpServletRequest request,
> HttpServletResponse response, Object handler) throws Exception {
> 
> 	  HandlerMethod handlerMethod = (HandlerMethod) handler;
> 	  Method method = handlerMethod.getMethod();
>     
> 	  System.out.println("Bean: " + handlerMethod.getBean());
> 	  System.out.println("Method: " + method);
> 	  	
> 	  return true;
> }
> ```
> 
> **postHandle**  
> `void postHandle(request, response, handler, modelAndView)`: 지정된 컨트롤러의 동작 이후에 처리하며,
> Spring MVC 의 Front Controller인 DispatcherServlet이 화면을 처리하기 전에 동작합니다.
> 
> 예를 들어, 특정한 메소드의 실행 결과를 HttpSession 객체에 같이 담아야 하는 경우를 생각해 볼 수 있습니다. 
> 컨트롤러에서는 Model 객체에 결과 데이터를 저장하고, 인터셉터의 PostHandle()에서 이를 이용해 HttpSession에 결과를 담는다면 
> 컨트롤러에서 HttpSession을 처리할 필요가 없게 됩니다.(실제로는 하면 안되는 짓...)  
> ```java
> @Override
> public void postHandle(HttpServletRequest request,
>                        HttpServletResponse response, Object handler,
>                        ModelAndView modelAndView) throws Exception {
> 
>     Object result = modelAndView.getModel().get("result");
> 
>     if (result != null) {
>         request.getSession().setAttribute("result", result);
>         response.sendRedirect("/home");
>     }
> }
> ```
> 
> **afterCompletion**  
> `void afterCompletion(request, response, handler, exception)`: DispatcherSerlvet 의 화면 처리(뷰)가 완료된 상태에서 처리합니다.
> 
> HandlerInterceptorAdapter 는 Spring 5.3 부터 Deprecated 되었다.  

### 참조사이트
> [Spring Interceptor, 제대로 이해하기](https://gngsn.tistory.com/153)  

---

## ControllerAdvice
### 개요
> @ControllerAdvice는 모든 @Controller 즉, 전역에서 발생할 수 있는 예외를 잡아 처리해주는 annotation 이다.  

### 예시
> ```java
> @Slf4j
> @RestControllerAdvice
> @RequiredArgsConstructor
> public class RestControllerExceptionHandler {
>     /**
>      * 지원하지 않은 Http Method 및 URI 로 요청한 경우 발생
>      */
>     @ExceptionHandler
>     @ResponseStatus(HttpStatus.BAD_REQUEST)
>     protected ErrorResponse handleHttpRequestMethodNotSupportedException(HttpServletRequest request,
>                                                                          HttpRequestMethodNotSupportedException e) {
>         log.error("[Handle HttpRequestMethodNotSupportedException] requestURI: {} {}",
>               request.getMethod(), request.getRequestURI(), e);
>         return ErrorResponse.from(e);
>     }
>     ...
> }
> ```

### Spring web 예외
> `HttpRequestMethodNotSupportedException`: 지원하지 않은 Http Method 및 URI 로 요청한 경우 발생.  
> `MethodArgumentNotValidException`: 애노테이션 @Valid 를 사용하여 데이터를 검증할 때 해당 데이터에 에러가 있는 경우 발생.  
> `ConstraintViolationException`: 애노테이션 @Validated 를 사용하여 데이터를 검증할 때 해당 데이터에 에러가 있는 경우 발생.  
> `BindException`: 애노테이션 @ModelAttribute 으로 binding error 발생시 BindException 발생.  
> `MethodArgumentTypeMismatchException`: Query string 으로 온 값이 @RequestParam 의 데이터에, PathVariable 로 온 값이 @PathVariable 데이터에 binding 되지 못했을 경우 발생.  
> `MissingServletRequestParameterException`: Query string 에 @RequestParam(required = true) 값이 누락된 경우 발생.  
> `MissingRequestHeaderException`: HTTP Header 에 @RequestHeader(required = true) 의 값이 누락된 경우 발생.  
> `HttpMessageNotReadableException`: Request body 로 온 JSON 문자열이 없거나, JSON 포멧이 아니거나 혹은 @RequestBody 애노테이션을 단 자료형으로 파싱 실패한 경우 발생.  
> `MissingServletRequestPartException`: Form 에 @RequestPart(required = true) 의 값이 누락된 경우 발생.

### 참조사이트
> [@ControllerAdvice, @ExceptionHandler를 이용한 예외처리 분리, 통합하기(Spring에서 예외 관리하는 방법, 실무에서는 어떻게?)](https://jeong-pro.tistory.com/195)

---

## Spring Validation
### @Valid의 개념 및 사용법
> @Valid는 JSR-303 표준 스펙(자바 진영 스펙)으로써 빈 검증기(Bean Validator)를 이용해 객체의 제약 조건을 검증하도록 지시하는 어노테이션이다. 
> JSR 표준의 빈 검증 기술의 특징은 객체의 필드에 달린 어노테이션으로 편리하게 검증을 한다는 것이다.  
> Spring에서는 일종의 어댑터인 LocalValidatorFactoryBean가 제약 조건 검증을 처리한다. 
> 이를 이용하려면 LocalValidatorFactoryBean을 빈으로 등록해야 하는데, SpringBoot에서는 아래의 의존성만 추가해주면 해당 기능들이 자동 설정된다.  
> ```groovy
> ...
> dependencies {
>     ...
>     implementation 'org.springframework.boot:spring-boot-starter-validation'
> }
> ...
> ```

### 예시
> AddUserRequest.java
> ```java
> @Getter
> @RequiredArgsConstructor
> public class AddUserRequest {
> 
> 	@Email
> 	private final String email;
> 
> 	@NotBlank
> 	private final String pw;
> 
> 	@NotNull
> 	private final UserRole userRole;
> 
> 	@Min(12)
> 	private final int age;
> }
> ```
> 
> HomeController.java
> ```java
> ...
> @PostMapping("/user/add") 
> public void addUser(@RequestBody @Valid AddUserRequest addUserRequest) {
> ...
> }
> ...
> ```

### @Valid 동작 원리
> 모든 요청은 프론트 컨트롤러인 디스패처 서블릿을 통해 컨트롤러로 전달된다. 전달 과정에서는 컨트롤러 메소드의 객체를 만들어주는 ArgumentResolver가 동작하는데, 
> @Valid 역시 ArgumentResolver에 의해 처리가 된다.  
> 대표적으로 @RequestBody 는 Json 메세지를 객체로 변환해주는 작업이 ArgumentResolver 의 구현체인 RequestResponseBodyMethodProcessor 가 처리하며, 
> 이 내부에서 @Valid로 시작하는 어노테이션이 있을 경우에 유효성 검사를 진행한다.  
> 만약 @ModelAttribute를 사용중이라면 ModelAttributeMethodProcessor에 의해 @Valid가 처리된다.  
> 
> 그리고 검증에 오류가 있다면 MethodArgumentNotValidException 예외가 발생하게 되고, 디스패처 서블릿에 기본으로 등록된 
> 예외 리졸버(Exception Resolver)인 DefaultHandlerExceptionResolver에 의해 400 BadRequest 에러가 발생한다.  
> 이러한 이유로 @Valid는 기본적으로 컨트롤러에서만 동작하며 기본적으로 다른 계층에서는 검증이 되지 않는다. 
> 다른 계층에서 파라미터를 검증하기 위해서는 @Validated와 결합되어야 하는데, 아래에서 @Validated와 함께 자세히 살펴보도록 하자.

### @Validated의 개념 및 사용법
> 입력 파라미터의 유효성 검증은 컨트롤러에서 최대한 처리하고 넘겨주는 것이 좋다. 하지만 개발을 하다보면 불가피하게 다른 곳에서 파라미터를 검증해야 할 수 있다. 
> Spring에서는 이를 위해 AOP 기반으로 메소드의 요청을 가로채서 유효성 검증을 진행해주는 @Validated 를 제공하고 있다. 
> @Validated는 JSR 표준 기술이 아니며 Spring 프레임워크에서 제공하는 어노테이션 및 기능이다.  
> 다음과 같이 클래스에 @Validated 를 붙여주고, 유효성을 검증할 메소드의 파라미터에 @Valid 를 붙여주면 유효성 검증이 진행된다.  
> 
> ```java
> @Service
> @Validated
> public class UserService {
> 
>     public void addUser(@Valid AddUserRequest addUserRequest) {
> 	      ...
> 	  }
> }
> ```
> 유효성 검증에 실패하면 에러가 발생하는데, 로그를 확인해보면 이전의 MethodArgumentNotValidException 예외가 아닌 
> `ConstraintViolationException` 예외가 발생했다. 이는 앞서 잠깐 설명한대로 동작 원리가 다르기 때문인데, 자세히 살펴보도록 하자.  

### @Validated 동작 원리 
> 특정 ArgumnetResolver에 의해 유효성 검사가 진행되었던 @Valid 와 달리, @Validated 는 AOP 기반으로 메소드 요청을 인터셉터하여 처리된다. 
> @Validated 를 클래스 레벨에 선언하면 해당 클래스에 유효성 검증을 위한 AOP의 어드바이스 또는 인터셉터(MethodValidationInterceptor)가 등록된다. 
> 그리고 해당 클래스의 메소드들이 호출될 때 AOP의 포인트 컷으로써 요청을 가로채서 유효성 검증을 진행한다.  
> 이러한 이유로 @Validated 를 사용하면 컨트롤러, 서비스, 레포지토리 등 계층에 무관하게 스프링 빈이라면 유효성 검증을 진행할 수 있다. 
> 대신 클래스에는 유효성 검증 AOP가 적용되도록 @Validated 를, 검증을 진행할 메소드에는 @Valid 를 선언해주어야 한다.  
> 이러한 이유로 @Valid 에 의한 예외는 MethodArgumentNotValidException이며, @Validated 에 의한 예외는 
> ConstraintViolationException 이다. 이를 알고 있으면 나중에 예외 처리를 할 때 도움이 된다.  

### Annotation
> 주요 애노테이션  
> `@Null`: null만 허용한다.  
> `@NotNull`: 빈 문자열(""), 공백(" ")은 허용하되, Null은 허용하지 않음  
> `@NotEmpty`: 공백(" ")은 허용하되, Null과 빈 문자열("")은 허용하지 않음  
> `@NotBlank`: null, 빈 문자열(""), 공백(" ") 모두 허용하지 않는다.  
> `@Email`: 이메일 형식을 검사한다. 단, 빈 문자열("")의 경우엔 통과 시킨다. @Pattern을 통한 정규식 검사를 더 많이 사용한다.    
> `@Pattern(regexp = )`: 정규식 검사할 때 사용한다.  
> `@Size(min =, max = )`: 길이를 제한할 때 사용한다.  
> `@Max(value = )`: value 이하의 값만 허용한다.  
> `@Min(value = )`: value 이상의 값만 허용한다.  
> `@Positive`: 값을 양수로 제한한다.  
> `@PositiveOrZero`: 값을 양수와 0만 가능하도록 제한한다.  
> `@Negative`: 값을 음수로 제한한다.  
> `@NegativeOrZero`: 값을 음수와 0만 가능하도록 제한한다.  
> `@Future`: Now 보다 미래의 날짜, 시간이어야 한다.  
> `@FutureOrPresent`: Now 거나 미래의 날짜, 시간이어야 한다.  
> `@Past`: Now 보다 과거의 날짜, 시간이어야 한다.  
> `@PastFutureOrPresent`: Now 거나 과거의 날짜, 시간이어야 한다.  

### 참조사이트
> [[Spring] @Valid와 @Validated를 이용한 유효성 검증의 동작 원리 및 사용법 예시 - (1/2)](https://mangkyu.tistory.com/174)

---

## Spring Multipart
### Multipart 가 생긴 이유
> Spring MVC 의 파일 업로드에 대해 알아보기 전에 Multipart/form-data 에 대해 먼저 알아야 합니다.  
> 우리가 일반적으로 폼 데이터를 전송하면 application/x-www-form-urlencoded 의 형식으로 전송됩니다. 
> HTTP body 에 바로 전송하고자 하는 데이터가 들어가는 형태입니다. name=kim&age=26 과 같은 key-value 쌍이 body에 들어가는 것이지요.  
> 이렇게 동일한 타입의 문자 데이터를 전송하는 것은 전혀 무리가 없습니다.
> 하지만 이런 key-value 형태의 문자데이터와 바이너리 형태의 파일 데이터가 함께 전송되어야 하는 경우엔 어떨까요?
> body 의 어디쯤에 여기부터는 파일이 전송되는 것이라고 알려주어야 할텐데 일반적인 application/x-www-form-urlencoded 타입으로는 불가능합니다.   
> 전송되는 각 폼 데이터를 구분해주어야 합니다. 여기서 구분되는 한 단위를 part라고 하고 동시에 여러 단위의 part를 나눌 수 있기에 multipart라는 이름이 
> 붙은 것 입니다.   
> 이렇게 body 에서 이 데이터를 구분해야하기 때문에 요청파라미터를 url 뒤에 문자열로 추가하는 GET 방식으로는 파일을 보낼 수 없습니다. 
> 그래서 multipart 타입은 POST 방식에서만 사용가능합니다.  
> 
> form 으로 파일 및 텍스트 등의 데이터를 같이 보냈을 때 request 요청은 다음과 같다.
> ```
> POST /someurl HTTP/1.1
> ...
> ...
> Content-type: multipart/form-data; boundary=---------------------------7d81c536d04c8       
> ...
> ...
> -----------------------------7d81c536d04c8                                                                    
> Content-Disposition: form-data; name="desc"
> 
> ...(텍스트 데이터)
> -----------------------------7d81c536d04c8                                                                  
> Content-Disposition: form-data; name="image"; filename="fileName.jpg"
> Content-Type: image/jpeg
> ...(Binary 이미지 데이터)
> ```

### multipart/form-data 파싱
> Spring 은 MultipartFile 타입을 제공합니다. 또한 감사하게도 @RequestParam, @ModelAttribute 를 모두 사용할 수 있습니다.  
> Client 에서 Content type 이 multipart/form-data 로 key value 데이터 및 파일 데이터를 전송한 경우 
> 스프링에서는 @RequestParam 을 통해서 key value 데이터 및 파일 데이터를 매개변수로 사용할 수 있다.  
> 
> ```java
> @Slf4j
> @Controller
> public class TestController {
>     ...
>     @PostMapping("/review/form")
>     public String form(@RequestParam String itemName,
>                        @RequestParam MultipartFile file) {
> 
>         if (!file.isEmpty()) {
>             String filename = file.getOriginalFilename();
>             log.info("file.getOriginalFilename = {}", filename);
> 
>             String fullPath = uploadDir + filename;
>             file.transferTo(new File(fullPath));
>         }
>         return "upload-form";
>     }
> }
> ```
> MultipartFile 의 `getOrifinalFilename()` 메서드를 통해서 파일명과 확장자까지 붙여서 문자열을 가져올 수 있다.  
> MultipartFile 의 `transferTo(file)` 메서드를 통해서 파일을 저장할 수 있다.  

### JSON + multipart 요청 처리
> Client 전송 예시   
> 전체 Content type: multipart/mixed  
> key value 데이터: request=JSON 문자열, Content type: application/json    
> 파일 데이터: imageFile=<file>, Content type: image/png  
> 로 전송하면 스프링에서는 각 key value 데이터 및 파일 데이터를 @RequestPart 로 받을 수 있다.  
> 다만 스프링에서는 @PostMapping 에서 consumes 에 `MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE` 를
> 설정해야한다.  
> ```java
> @RestController
> @Slf4j
> public class TestController {
> 
>     @PostMapping(value = "/api/v1/character", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
>     public void saveCharacter(@RequestPart CharacterCreateRequest request,
>                               @RequestPart MultipartFile imageFile) {
>         log.info("이름 : {}, 나이 : {}, 이미지 : {}", request.getAge(), request.getName(), imgFile);
>     }
> }
> ```

### MultipartFile 의 메서드
> `String getName()`: 파라미터의 이름 <input> 태그의 이름  
> `String getOriginalFilename()`: 업로드되는 파일의 이름  
> `boolean isEmpty()`: 파일이 존재하지 않는 경우 true  
> `long getSize()`: 업로드되는 파일의 크기  
> `byte[] getBytes()`: byte[]로 파일 데이터 반환  
> `inputStream getInputStream()`: 파일데이터와 연결된 inputStream을 반환  
> `transferTo(File file)`: 파일의 저장  

### 참조사이트
> [Spring MVC (15) 파일 업로드1 (Multipart/form-data, MultipartFile)](https://velog.io/@dhk22/Spring-MVC-15-%ED%8C%8C%EC%9D%BC-%EC%97%85%EB%A1%9C%EB%93%9C1-Multipartform-data-MultipartFile)    
> [Spring Multipart 및 파일업로드 (study4_4)](https://brilliantdevelop.tistory.com/111)    
> [Spring Web MVC - Multipart 요청 다루기](https://ykh6242.tistory.com/entry/Spring-Web-MVC-Multipart-%EC%9A%94%EC%B2%AD-%EB%8B%A4%EB%A3%A8%EA%B8%B0)  

---

## Server push
### Server push 가 필요한 경우
> * 클라이언트에서 실시간 데이터 업데이트 페이지가 필요한 경우
> * 클라이언트에서 실시간 알림 기능을 제공하는 경우
> * 기타 등등

### Server push 구현 방법
> 1.polling(client poll) 방식: 클라이언트가 일정한 주기로 서버에 업데이트 요청을 보내는 방법. 지속적인 HTTP 요청이 발생하기 때문에 리소스 낭비가 발생한다.
> 
> 2.websocket 방식: 실시간 양방향 통신을 위한 스펙으로 서버와 브라우저가 지속적으로 연결된 TCP라인을 통해 실시간으로 데이터를 주고받을 수 있도록 하는 
> HTML5 사양이다. 연결지향 양방향 전이중 통신이 가능하며 채팅, 게임, 주식 차트 등에 사용된다. polling은 주기적으로 HTTP 요청을 수행하지만, 
> websocket은 연결을 유지하여 서버와 클라이언트 간 양방향 통신이 가능하다.  
> 
> 3.SSE(server push event) 방식: 이벤트가 [서버 -> 클라이언트] 방향으로만 흐르는 단방향 통신 채널이다. 
> SSE는 클라이언트가 polling과 같이 주기적으로 http 요청을 보낼 필요없이 http 연결을 통해 서버에서 클라이언트로 데이터를 보낼 수 있다.  

### SSE in Spring 
> spring framework 4.2 부터는 `SseEmitter` 클래스를 통해서 구현할 수 있다.   
> spring framework 5 부터는 WebFlux 를 통해서 SSE 통신이 가능하다.  

### 참조사이트
> [[Spring + SSE] Server-Sent Events를 이용한 실시간 알림](https://velog.io/@max9106/Spring-SSE-Server-Sent-Events%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EC%8B%A4%EC%8B%9C%EA%B0%84-%EC%95%8C%EB%A6%BC)  

---

## Firebase
### 프로젝트 추가
> 링크: https://console.firebase.google.com/   
> Firebase 콘솔 페이지에서 프로젝트 추가 버튼을 클릭하여 추가한다.

### FCM 관련 용어
> **Notification Server**  
> GCM, APNs 와 같이, mobile 기기에 Push 알림을 전송하는 서버입니다.
> 
> **Client App**  
> 사용자의 mobile기기에 설치된 app을 의미합니다. Push 알림을 받는 역할을 합니다.
> 
> **Provider**  
> Client App 을 위한 서버입니다. 필요시 Notification Server 에 요청을 전송하여, Notification Server 가 Client App 에 알림을 보냅니다.  

### FCM 전송을 위한 빌드업 과정
> 1.Client App을 Notification Server 에 등록합니다.  
> 2.Client App을 켜면 각각의 Client App 을 구분하는 Token 을 Notification Server 에서 발급합니다.  
> 3.Client App에서 이 Token 을 Provider 로 전송합니다.  
> 4.Provider는 Token 을 저장해둡니다.  
> 5.Client App에 알림을 전송할 필요가 있을때, Token 값과 함께 Notification Server에 요청합니다.  
> 6.Client App에서 Push 알림을 수신합니다.  

### Provider 설정(SpringBoot server)
> 1.Firebase 콘솔 페이지에서 추가한 프로젝트로 들어간 후 좌측 네이게이션 바에서 프로젝트 개요 옆에 톱니바퀴를 클릭한다.  
> 2.Settings 에서 서비스 계정 탭을 클릭 후 Firebase Admin SDK 를 클릭 후 새 비공개 키 생성 버튼을 클릭하여 비공개 키를 다운로드 받는다.    
> 3.다운로드 받은 비공개 키인 firebase_service_key.json 을 SpringBoot 프로젝트의 `src/main/resources/firebase` 디렉터리 하위에 넣는다.  
> 4.의존성을 추가한다.  
> ```groovy
> ...
> dependencies {
>     ...
>     implementation 'com.google.firebase:firebase-admin:9.1.1'
>     ...
> }
> ```
> 구현은 현재 프로젝트의 src/main/java/starter.springweb.external.client.apppush 를 참조한다.

### 참조사이트
> [Spring Boot - FCM Push 서버 구축하기](https://galid1.tistory.com/740)

---

## Spring Cloud
### Feign Client
> Spring Cloud 에서 Rest API 를 간편 호출하도록 하는 클라이언트  
> 
> build.gradle
> ```groovy
> ext {
>     ...
>     set('springCloudVersion', "2020.0.2")
> }
> ...
> dependencies {
>     ...
>     implementation 'org.springframework.cloud:spring-cloud-starter-openfeign'
>     implementation group: 'io.github.openfeign', name: 'feign-gson', version: '11.0'
> }
> ```
> 
> **FeignClient 정의**    
> SampleFeignClient.java
> ```java
> @FeignClient(name = "sampleFeign", url = "http://localhost:8080/feign/sample", configuration = FeignSampleConfig.class)
> public interface SampleFeignClient {
>     @GetMapping("/{owner}/{repo}/sample")
>     List<SampleDto> listSampleDto(@PathVariable("owner") String owner, @PathVariable("repo") String repo);
> }
> ```
> 
> **FeignClient 사용**   
> UsingFeignClientService.java
> ```java
> @RequiredArgsConstructor
> public class UsingFeignClientService {
>     private final SampleFeignClient sampleFeignClient;
>      
>     public void useFeignClient() {
>         List<SampleDto> sampleDtos = sampleFeignClient.listSampleDto("ownerSample", "repoSample");
>         ...
>     }
> }
> ```
> 
> FeignClient 를 Spring 에서 사용하기 위해서는 Main 클래스에 `@EnableFeignClient` 애노테이션 선언이 필요하다.  
> MainApplication.java
> ```java
> @EnableFeignClient
> @SpringBootApplication
> public class MainApplication {
>     public static void main(String[] args) {
>         SpringApplication.run(MainApplication.class, args);
>     }
> }
> ```
