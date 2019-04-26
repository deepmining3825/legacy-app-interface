package lai.module.starter.config;

import com.diquest.lai.module.servlet.ModuleConfigurer;
import lai.module.starter.sample.SampleEndpoint;

import java.util.ArrayList;
import java.util.List;

/**
 * LAI Module 설정
 * <p>
 * LAI Module 은 자바설정을 사용합니다.
 * 설정객체는 ModuleConfigurer 객체를 상속받습니다.
 */
public class ModuleConfig implements ModuleConfigurer {

    @Override
    public List<Object> getEndpoints() {
        List<Object> list = new ArrayList<>();
        list.add(new SampleEndpoint());

        return list;
    }

}
