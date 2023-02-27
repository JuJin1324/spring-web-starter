# spring-web-starter

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
> 

### org.springframework.data.domain.Slice
> 

---

## ArgumentResolver


---

## Interceptor


---

## ControllerAdvice


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

---

## WebConfig
### Configuration class
> 

### Static resources
> 

### CORS Settings
> 

### Trim Json String
> 

### ObjectMapper Modules
> 

