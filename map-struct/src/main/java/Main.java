import convert.CarCovertBasic;
import org.mapstruct.ap.shaded.freemarker.template.utility.DateUtil;
import po.CarPo;
import vo.CarVo;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 和BeanUtils相比得优势：
 * (1)两个类型属性不一致
 * (2)集合类型转换
 * (3)类型不一致
 */
public class Main {
    public static void main(String[] args) {
        CarPo carPo = CarPo.builder().id(1)
                .brand("BMW")
                .carName("宝马")
                .createTime(new Date())
                .build();

        //carPo的属性值复制给carVo
//        CarVo carVo = CarCovertBasic.INSTANCE.toConvertVo(carPo);
//        System.out.println(carVo);
//
//        // 集合类型转换
//        List<CarPo> carPos = Collections.singletonList(carPo);
//        List<CarVo> carVos = CarCovertBasic.INSTANCE.toConvertVos(carPos);
//        System.out.println(carVos);

        //类型不一致
        CarVo carVo = CarCovertBasic.INSTANCE.toConvertVo(carPo);
        System.out.println(carVo);
    }
}
