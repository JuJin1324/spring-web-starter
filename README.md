# spring-web-starter

## Apache tomcat
### TODO
> TODO

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
> 디폴트 값으로 classpath:/static 으로 되어 있음으로 만약 src/resources/static 디렉터리 경로에 외부 접근 파일을
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
> public class JacksonConfiguration {
> 
>     public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
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
>     }
> 
>     class ZonedDateTimeTimeSerializer extends JsonSerializer<ZonedDateTime> {
>         @Override
>         public void serialize(ZonedDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
>             gen.writeString(value.format(FORMATTER));
>         }
>     }
> 
>     class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {
>         @Override
>         public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
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
> TODO 

### org.springframework.data.domain.Slice
> TODO

---

## ArgumentResolver
### TODO
> TODO

---

## Interceptor
### TODO
> TODO

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
