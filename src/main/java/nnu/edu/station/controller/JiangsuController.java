package nnu.edu.station.controller;

import nnu.edu.station.common.result.JsonResult;
import nnu.edu.station.common.result.ResultUtils;
import nnu.edu.station.service.JiangsuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Yiming
 * @Date: 2023/02/11/22:03
 * @Description:
 */
@RestController
@RequestMapping("/jiangsu")
public class JiangsuController {
    @Autowired
    JiangsuService jiangsuService;

    @RequestMapping(value = "/getInfoByStation/{station}", method = RequestMethod.GET)
    public JsonResult getInfoByStation(@PathVariable String station) {
        return ResultUtils.success(jiangsuService.getInfoByStation(station));
    }

    @RequestMapping(value = "/getInfoByStationAndTime/{station}/{startTime}/{endTime}", method = RequestMethod.GET)
    public JsonResult getInfoByStationAndTime(@PathVariable String station, @PathVariable String startTime, @PathVariable String endTime) {
        return ResultUtils.success(jiangsuService.getInfoByStationAndTime(station, startTime, endTime));
    }
}


//controller文件是一个Java类文件，它使用了Spring Boot框架的注解来定义请求映射路径和处理方法。这个文件的主要功能是接收用户的请求，并调用service层的接口来执行业务逻辑，然后返回相应的数据给用户。这个文件的具体内容如下：
//第一行package nnu.edu.station.controller;是声明这个类属于哪个包，也就是说这个类的完整名称是nnu.edu.station.controller.JiangsuController。
//第二行到第八行是导入一些需要用到的类或接口，例如JsonResult、JiangsuService等。
//第九行@RestController是一个类级别的注解，它表示这个类是一个控制器类，并且它的所有方法都会返回JSON格式的数据，而不是视图（例如HTML页面）。
//第十行@RequestMapping("/jiangsu")也是一个类级别的注解，它表示这个类处理的所有请求都以/jiangsu为前缀。
//第十一行和第十二行是声明一个私有字段jiangsuService，并使用@Autowired注解来自动注入一个实现了JiangsuService接口的对象。这样就可以在后面的方法中调用这个对象的方法来执行业务逻辑。
//第十四行到第十六行是定义一个方法getInfoByStation，它有一个参数station，用来表示用户想要查询的站点名称。这个方法使用了两个注解：
//@RequestMapping(value = "/getInfoByStation/{station}", method = RequestMethod.GET)表示这个方法处理的请求路径是/jiangsu/getInfoByStation/{station}，其中{station}是一个路径变量，用来动态匹配用户输入的站点名称。另外，这个注解还指定了请求方法必须是GET。
//@PathVariable String station表示这个参数是从路径变量中获取的，并且它的名称和路径变量中的名称一致。
//这个方法的返回值是一个JsonResult对象，它是一个自定义的类，用来封装返回给用户的数据和状态码等信息。这个对象由一个静态方法ResultUtils.success()创建，并传入了调用了jiangsuService.getInfoByStation(station)方法得到的数据作为参数。这个方法就是执行业务逻辑的地方，它会根据站点名称查询数据库或其他数据源，并返回相应的信息。
//第十八行到第二十一行是定义另一个方法getInfoByStationAndTime，它有三个参数：station、startTime和endTime，分别表示用户想要查询的站点名称、开始时间和结束时间。这个方法和上面的方法类似，只不过它处理的请求路径是 /jiangsu/getInfoByStationAndTime/{station}/{startTime}/{endTime}，并且它调用了 jiangsuService.getInfoByStationAndTime(station, startTime, endTime)方法来执行业务逻辑。