package lai.module.starter.sample;

import com.diquest.lai.LookupResult;
import com.diquest.lai.LookupValue;
import com.diquest.lai.client.LaiClient;
import com.diquest.lai.client.LaiClientConfig;
import com.diquest.lai.logger.LoggerWrapper;
import com.diquest.lai.logger.LoggerWrapperFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleEndpointTests {

    private static final LoggerWrapper log = LoggerWrapperFactory.createLogger(SampleEndpointTests.class);

    private static LaiClient client;

    @BeforeClass
    public static void init() {
        LaiClientConfig config = new LaiClientConfig();
        config.setBaseUrl("http://localhost:8080");

        client = new LaiClient();
        client.setConfig(config);
    }

    @Test
    public void hello() {
        Map<String, String> param = new HashMap<>();
        param.put("name", "홍길동");

        LookupValue value1 = client.lookup().query("starter.sample.hello.message", param);
        log.info(">> {}", value1);
        Assert.assertEquals("안녕하세요! 홍길동님", value1.getValue());

        String value2 = client.lookup().queryValue("starter.sample.hello.message", param, String.class);
        log.info(">> {}", value2);
        Assert.assertEquals("안녕하세요! 홍길동님", value2);
    }

    @Test
    public void currentTime() {
        List<String> keys = new ArrayList<>();
        keys.add("starter.sample.current.date");
        keys.add("starter.sample.current.time");
        keys.add("starter.sample.current.datetime");

        LookupResult result = client.lookup().query(keys);
        log.info("Date: {}", result.getValue("starter.sample.current.date"));
        log.info("Time: {}", result.getValue("starter.sample.current.time"));
        log.info("Datetime: {}", result.getValue("starter.sample.current.datetime"));
    }

}
