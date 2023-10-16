package nnu.edu.station.dao.level;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Yiming
 * @Date: 2023/02/11/22:05
 * @Description:
 */
@Repository
public interface JiangsuMapper {
    List<Map<String, Object>> getInfoByStation(@Param("station") String station);

    List<Map<String, Object>> getInfoByStationAndTime(@Param("station") String station, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<String> getStationName();

    String quireEarliestTime();

    String quireNowTime();
}


//@Repository注解标识了JiangsuMapper接口是一个数据访问对象（DAO）。它告诉Spring容器将这个接口的实现类注册为一个bean，以便在其他地方可以自动注入这个DAO。
//同名xml文件用来实现mapper接口，实现方式为定义xml语句。xml位于相同包路径下（nnu.edu.station.dao.level.JiangsuMapper），在项目中位置在resources/mapper.level
//@Param("station")表明station参数值传递给SQL语句中的 #{station}