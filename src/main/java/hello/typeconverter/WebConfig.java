package hello.typeconverter;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 스프링이 기본으로 들고있는 ConversionService 에 컨버터 등록
    @Override
    public void addFormatters(FormatterRegistry registry) {
        // 우선순위: 컨버터 > 포매터
        // MyNumberFormatter를 적용하려면 String, 숫자 타입의 컨버터 주석처리하고 실행해야 함
        //registry.addConverter(new StringToIntegerConverter());
        //registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        // 포매터 등록
        registry.addFormatter(new MyNumberFormatter());
    }
}
