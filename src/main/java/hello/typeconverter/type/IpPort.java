package hello.typeconverter.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;

// "127.0.0.1:8080" 을 아래 두 데이터로 변형
// 혹은 아래 두 데이터를 "127.0.0.1:8080" 하고 싶을 때
@Getter
@EqualsAndHashCode
public class IpPort {
    private String ip;
    private int port;

    public IpPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}
