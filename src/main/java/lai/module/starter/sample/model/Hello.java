package lai.module.starter.sample.model;

import com.diquest.lai.module.Param;
import lombok.Data;

@Data
public class Hello {

    @Param(description = "이름", required = true, sample = "홍길동")
    private String name;

    @Param(description = "인사말", required = true, sample = "안녕하세요! 홍길동님")
    private String message;

}
