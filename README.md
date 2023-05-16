# spring-web-starter

## Apache tomcat
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
> **Connection 관련**  
> `server.tomcat.connection-timeout`: 커넥션 타임아웃 설정, 기본값은 없다.    
> `server.tomcat.keep-alive-timeout`: 커넥션 종료 전 다른 HTTP 요청을 기다리는 시간 설정. 설정하지 않으면 connection-timeout 이 사용, 
> -1 이면 무한. 기본값은 100.  
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

## ObjectMapper
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
>             gen.writeString(StringUtils.trimWhitespace(value));
>         }
>     }
>     
>     static class TrimStringDeserializer extends JsonDeserializer<String> {
>         @Override
>         public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
>             return StringUtils.trimWhitespace(p.getValueAsString());
>         }
>     }
> }
> ```

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
> boolean supportsParameter(MethodParameter parameter);
> 
> @Nullable
> Object resolveArgument(MethodParameter parameter, @Nullable ModelAndViewContainer mavContainer, NativeWebRequest webRequest, @Nullable WebDataBinderFactory binderFactory) throws Exception;
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
> 컨트롤러에서 HttpSession을 처리할 필요가 없게 됩니다.  
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
### TODO
> TODO

---

## Spring Validation
### dependencies
> ```groovy
> ...
> dependencies {
>     ...
>     implementation 'org.springframework.boot:spring-boot-starter-validation'
> }
> ...
> ```

### TODO
> TODO

---

## Spring Multipart
### TODO
> TODO

---

## Server push
### TODO
> TODO
