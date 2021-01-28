package convert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import po.CarPo;
import vo.CarVo;

import java.util.List;

/**
 * MapStruct插件会识别我们的接口，生成一个实现类，在实现类中，为我们实现了set逻辑
 */
@Mapper
public interface CarCovertBasic {
    CarCovertBasic INSTANCE = Mappers.getMapper(CarCovertBasic.class);

    // 两个类型属性不一致
    @Mappings({
            @Mapping(source = "carName", target = "name"),
            @Mapping(target = "createTime", expression = "java(com.util.DateUtil.dateToStr(source.getCreateTime()))")
    })
    CarVo toConvertVo(CarPo source);

    // 集合类型转换
    List<CarVo> toConvertVos(List<CarPo> source);
}
