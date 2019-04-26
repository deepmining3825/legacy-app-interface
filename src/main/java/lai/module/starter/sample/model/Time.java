package lai.module.starter.sample.model;

import com.diquest.lai.module.Param;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Time {

    private static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");

    private static final SimpleDateFormat hhmmss = new SimpleDateFormat("hh:mm:ss");

    private static final SimpleDateFormat yyyyMMddhhmmss = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Param(description = "일자", required = true, sample = "2017-01-01")
    private String date;

    @Param(description = "시간", required = true, sample = "15:00:00")
    private String time;

    @Param(description = "일자시간", required = true, sample = "2017-01-01 15:00:00")
    private String datetime;

    public Time() {
    }

    public Time(Date date) {
        this.date = yyyyMMdd.format(date);
        this.time = hhmmss.format(date);
        this.datetime = yyyyMMddhhmmss.format(date);
    }

}
