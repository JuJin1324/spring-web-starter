package starter.springweb.web.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2023/04/13
 */
@Configuration
public class JacksonConfig {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    @Bean
    @Primary
    public ObjectMapper serializingObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(javaTimeModule());
        objectMapper.registerModule(trimStringModule());
        return objectMapper;
    }

    private JavaTimeModule javaTimeModule() {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(ZonedDateTime.class, new ZonedDateTimeTimeSerializer());
        javaTimeModule.addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer());
        return javaTimeModule;
    }

    static class ZonedDateTimeTimeSerializer extends JsonSerializer<ZonedDateTime> {
        @Override
        public void serialize(ZonedDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.format(FORMATTER));
        }
    }

    static class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {
        @Override
        public ZonedDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return ZonedDateTime.parse(p.getValueAsString(), FORMATTER);
        }
    }

    private TrimStringModule trimStringModule() {
        TrimStringModule trimStringModule = new TrimStringModule();
        trimStringModule.addSerializer(String.class, new TrimStringSerializer());
        trimStringModule.addDeserializer(String.class, new TrimStringDeserializer());
        return trimStringModule;
    }

    static class TrimStringModule extends SimpleModule {
    }

    static class TrimStringSerializer extends JsonSerializer<String> {
        @Override
        public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(StringUtils.trimWhitespace(value));
        }
    }

    static class TrimStringDeserializer extends JsonDeserializer<String> {
        @Override
        public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return StringUtils.trimWhitespace(p.getValueAsString());
        }
    }
}
