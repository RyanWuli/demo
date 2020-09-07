package com.zxw.supermall.controller;


import com.alibaba.fastjson.JSONObject;
import com.zxw.supermall.common.ResponseResult;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Ryan
 * @since 2020-08-20
 */
@RestController
@RequestMapping("/supermall/goods")
public class GoodsController {

    @GetMapping("/{iid}")
    public ResponseResult<JSONObject> getDetails(@PathVariable("iid") String iid) {

        String result = "{\n" +
                "\"result\":{\n" +
                "    \"columns\":[\"销量 1580\",\"收藏33人\",\"默认快递\"],\n" +
                "    \"itemInfo\":{\n" +
                "        \"iid\":\"1kbwcv2\",\n" +
                "        \"orgPrice\":\"¥57\",\n" +
                "        \"price\":\"¥39.8\",\n" +
                "        \"title\":\"纯棉短袖女2020新款潮夏季黑色t恤紧身上衣修身网红韩范体恤\",\n" +
                "        \"discountDesc\":\"优惠价\",\n" +
                "        \"discountBgColor\":\"#ff8198\",\n" +
                "        \"topImages\":[\n" +
                "            \"https://s11.mogucdn.com/mlcdn/c45406/190805_65dhff40fehd91l0k7a211h63gej0_800x1200.jpg_640x960.v1cAC.70.png\",\n" +
                "            \"https://s5.mogucdn.com/mlcdn/c45406/190805_4ge3e1gg47bi84637fhie80i2lah0_800x1200.jpg_640x960.v1cAC.70.png\",\n" +
                "            \"https://s5.mogucdn.com/mlcdn/c45406/190805_4ck9l59cjf7ihd1kd5j53e81bdd66_750x1000.jpg_640x960.v1cAC.70.png\",\n" +
                "            \"https://s5.mogucdn.com/mlcdn/c45406/190805_45c9d501504hd1l2h9760cd2dd813_800x800.jpg_640x960.v1cAC.70.png\",\n" +
                "            \"https://s5.mogucdn.com/mlcdn/c45406/190805_3kfbj9l4fja8ee3bh7il4hfgljeki_800x1200.jpg_640x960.v1cAC.70.png\",\n" +
                "            \"https://s5.mogucdn.com/mlcdn/c45406/170801_856c7b1k8i8c451f510bbgld548d7_800x1200.jpg_640x960.v1cAC.70.png\",\n" +
                "            \"https://s11.mogucdn.com/mlcdn/c45406/190805_3h69cgdg52a70750j81faia9ffkg5_800x800.jpg_640x960.v1cAC.70.png\",\n" +
                "            \"https://s5.mogucdn.com/mlcdn/c45406/190805_1c1f0c107bjc1c25al902g1i36jib_800x1200.jpg_640x960.v1cAC.70.png\",\n" +
                "            \"https://s5.mogucdn.com/mlcdn/c45406/190805_15habaf79hfl8bfa614193lc086i9_800x800.jpg_640x960.v1cAC.70.png\",\n" +
                "            \"https://s5.mogucdn.com/mlcdn/c45406/190228_744kek357kaeieekh978856ide28k_800x800.jpg_640x960.v1cAC.70.png\"\n" +
                "        ]\n" +
                "    },\n" +
                "    \"shopInfo\":{\n" +
                "        \"service\":[\n" +
                "            {\n" +
                "                \"icon\":\"https://s10.mogucdn.com/mlcdn/c45406/180417_25kbfg1c3hdbd120394ji4b11bk2k_36x36.png_80x80.v1cAC.40.png\",\n" +
                "                \"name\":\"退货补运费\"\n" +
                "            },{\n" +
                "                \"icon\":\"https://s10.mogucdn.com/mlcdn/c45406/180417_25kbfg1c3hdbd120394ji4b11bk2k_36x36.png_80x80.v1cAC.40.png\",\n" +
                "                \"name\":\"全国包邮\"\n" +
                "            },{\n" +
                "                \"icon\":\"https://s10.mogucdn.com/mlcdn/c45406/180417_25kbfg1c3hdbd120394ji4b11bk2k_36x36.png_80x80.v1cAC.40.png\",\n" +
                "                \"name\":\"7天无理由退货\"\n" +
                "            },{\n" +
                "                \"icon\":\"https://s10.mogucdn.com/mlcdn/c45406/180417_25kbfg1c3hdbd120394ji4b11bk2k_36x36.png_80x80.v1cAC.40.png\",\n" +
                "                \"name\":\"72小时发货\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"shopLogo\":\"https://s5.mogucdn.com/mlcdn/c45406/190217_5g7j3chik438d91j3ac3dh4f6cf98_200x200.jpg_120x120.png\",\n" +
                "        \"name\":\"小甜心STUDIO\",\n" +
                "        \"score\":[\n" +
                "            {\"isBetter\":false,\"name\":\"描述相符\",\"score\":4.64},\n" +
                "            {\"isBetter\":true,\"name\":\"价格合理\",\"score\":5},\n" +
                "            {\"isBetter\":false,\"name\":\"质量满意\",\"score\":4.62}\n" +
                "        ],\n" +
                "        \"cGoods\": 99,\n" +
                "        \"cSells\":59876\n" +
                "    },\n" +
                "    \"detailsInfo\":{\n" +
                "        \"desc\":\"新款上市\",\n" +
                "        \"detailImage\":{\n" +
                "            \"key\":\"新款上市\",\n" +
                "            \"desc\":\"韩国品牌同款的T恤，很显气质的一款。 棉质面料很厚实，买过就会知道了，弹力和柔软性都不错。 小圆领，更有女人味，版型剪裁偏修身，能更好 的凸显身材，搭配上小脚的牛仔裤或者高腰裙子，都是 非常时尚的。入了多种颜色，都是显气质的色彩~~\",\n" +
                "            \"list\":[\n" +
                "            \t\"https://s5.mogucdn.com/mlcdn/c45406/200219_632bc16ecfl71hf6ba10b3aee51f4_750x1150.jpg_468x468.png\",\n" +
                "            \t\"https://s11.mogucdn.com/mlcdn/c45406/190805_7350kkikc2ablacka41bjbg977g4a_750x638.jpg_468x468.png\",\n" +
                "            \t\"https://s5.mogucdn.com/mlcdn/c45406/200219_6lkga7l70b5b9gg0ff0b1hg87ckjc_750x1500.jpg_468x468.png\",\n" +
                "            \t\"https://s11.mogucdn.com/mlcdn/c45406/190805_34664kj6ba32hicl06j7e138b3kjh_750x1300.jpg_468x468.png\",\n" +
                "            \t\"https://s5.mogucdn.com/mlcdn/c45406/190805_5cclk94b2jl9h4cc601hh0bg7jfj2_750x1040.jpg_468x468.png\",\n" +
                "            \t\"https://s5.mogucdn.com/mlcdn/c45406/190805_0gfe8bi80601jdcg19497ee7iadfh_750x1120.jpg_468x468.png\",\n" +
                "            \t\"https://s11.mogucdn.com/mlcdn/c45406/190805_5d604b9b83l2f5c4khe027j77j122_750x345.jpg_468x468.png\",\n" +
                "            \t\"https://s11.mogucdn.com/mlcdn/c45406/200219_2cc9gf5k0j55h75idf7c00hl3ef9j_750x1162.jpg_468x468.png\",\n" +
                "            \t\"https://s5.mogucdn.com/mlcdn/c45406/190805_0l0d8cf48fjk51a9i8ief892ifj68_750x1300.jpg_468x468.png\",\n" +
                "            \t\"https://s5.mogucdn.com/mlcdn/c45406/190805_27hei38dc0fc3c219gib87j26ega6_750x853.jpg_468x468.png\",\n" +
                "            \t\"https://s5.mogucdn.com/mlcdn/c45406/190805_482laa35aa4cl96hg850bgih72dda_750x857.jpg_468x468.png\",\n" +
                "            \t\"https://s5.mogucdn.com/mlcdn/c45406/190805_6kf59025gi69570cdf9804dl9djjc_750x1540.jpg_468x468.png\",\n" +
                "           \t\t\"https://s11.mogucdn.com/mlcdn/c45406/190805_5eihk79dk5b8ljc89c7ge2f76gkil_750x975.jpg_468x468.png\",\n" +
                "            \t\"https://s5.mogucdn.com/mlcdn/c45406/190805_33kk1f4hch6d19gb6k4kf44b8g0i1_750x1074.jpg_468x468.png\",\n" +
                "       \t\t\t\"https://s5.mogucdn.com/mlcdn/c45406/190805_69iccb799d66730lh60ig4d838e2c_750x1540.jpg_468x468.png\",\n" +
                "            \t\"https://s11.mogucdn.com/mlcdn/c45406/190805_4glek4di0l6hd42hl0jfge9hljajh_750x1500.jpg_468x468.png\",\n" +
                "            \t\"https://s5.mogucdn.com/mlcdn/c45406/190805_132da4ff338kc6b2e9lb7l0i8fal8_750x1500.jpg_468x468.png\",\n" +
                "            \t\"https://s5.mogucdn.com/mlcdn/c45406/190805_6c96g7dhj7hha72a981bhadbehf51_750x1500.jpg_468x468.png\",\n" +
                "            \t\"https://s11.mogucdn.com/mlcdn/c45406/190805_435663g4i1c06f03382j78k0a999a_750x1500.jpg_468x468.png\"\n" +
                "            ]\n" +
                "        }\n" +
                "    },\n" +
                "\t\"itemParams\":{\n" +
                "        \"info\":{\n" +
                "            \"key\":\"产品参数\",\n" +
                "            \"set\":[\n" +
                "                {\"key\":\"图案\",\"value\":\"宫廷复古图/民族复古图，字母/文字/数字\"},\n" +
                "                {\"key\":\"厂名\",\"value\":\"艾玫莉服饰有限公司\"},\n" +
                "                {\"key\":\"颜色\",\"value\":\"黑白拼接\"},\n" +
                "                {\"key\":\"袖型\",\"value\":\"常规袖\"},\n" +
                "                {\"key\":\"上衣厚度\",\"value\":\"适中\"},\n" +
                "                {\"key\":\"尺码\",\"value\":\"M,L,XL,XXL\"},\n" +
                "                {\"key\":\"衣长\",\"value\":\"常规款（51-65cm）\"},\n" +
                "                {\"key\":\"版型\",\"value\":\"宽松\"},\n" +
                "                {\"key\":\"季节\",\"value\":\"春秋\"},\n" +
                "                {\"key\":\"厂址\",\"value\":\"广东省揭阳市普宁市池尾镇\"},\n" +
                "                {\"key\":\"材质\",\"value\":\"棉\"},\n" +
                "                {\"key\":\"领型\",\"value\":\"圆领\"},\n" +
                "                {\"key\":\"元素\",\"value\":\"面料拼接\"},\n" +
                "                {\"key\":\"袖长\",\"value\":\"长袖\"},\n" +
                "                {\"key\":\"风格\",\"value\":\"原宿\"},\n" +
                "                {\"key\":\"潮流\",\"value\":\"韩系\"}\n" +
                "            ]\n" +
                "        },\n" +
                "        \"rule\":{\n" +
                "            \"table\":[\n" +
                "                [\"尺码\",\"M\",\"L\",\"XL\",\"XXL\"],\n" +
                "        \t\t[\"衣长\",\"61.5\",\"63\",\"64.5\",\"66\"],\n" +
                "\t\t\t\t[\"胸围\",\"98\",\"104\",\"110\",\"116\"],\n" +
                "\t\t\t\t[\"袖长\",\"63\",\"66\",\"68.5\",\"70.5\"]\n" +
                "            ]\n" +
                "        }\n" +
                "    },\n" +
                "\t\"commontInfo\":[{\n" +
                "        \"headImg\":\"https://s5.mogucdn.com/mlcdn/5abf39/180114_13a91k46hf2liikc1ikk4fhe1kkd2_132x132.jpg_48x48.png\",\n" +
                "        \"name\":\"爱之搁浅Vera\",\n" +
                "        \"content\":\"东西挺好，上衣有光泽度\",\n" +
                "        \"time\":\"2020-08-20\"\n" +
                "    },{\n" +
                "        \"headImg\":\"https://s11.mogucdn.com/b7/avatar/151201/1qjthq_ie4gemjwhfqtanbtguzdambqgiyde_1080x1920.jpg_48x48.png\",\n" +
                "        \"name\":\"a妮妮ninixin\",\n" +
                "        \"content\":\"收到货，第一时间拆包装，感觉质量还是比较好的，非常满意，发货速度比较快，运送速度很快，总的来说这次是很满意的一次购物，感谢甜心，期待更多好看的衣服！\",\n" +
                "        \"time\":\"2020-08-21\"\n" +
                "    }],\n" +
                "\t\"preferInfo\":[\n" +
                "        {\n" +
                "            \"iid\":\"1kbwcv2\",\n" +
                "            \"url\":\"https://s11.mogucdn.com/mlcdn/c024f5/190417_2d51ljj2a42lddkg49ibag494g3ca_1125x540.png_468x468.png\",\n" +
                "            \"title\":\"白色t恤女装超火cec短袖2020新款潮针织紧身打底网红半袖\",\n" +
                "            \"price\":\"¥39.8\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"iid\":\"1kbwcv2\",\n" +
                "            \"url\":\"https://s11.mogucdn.com/p2/161008/93163408_34i649lfk9e65752la4fa2fdd4075_800x1200.jpg_320x999.png\",\n" +
                "            \"title\":\"白色t恤女春装新款中袖上衣内搭紧身打底衫女春秋韩版百搭五分袖\",\n" +
                "            \"price\":\"¥49.8\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"iid\":\"1kbwcv2\",\n" +
                "            \"url\":\"https://s5.mogucdn.com/mlcdn/c45406/190309_575jk0bk14k175g5a5jca2hdk91bl_800x1200.jpg_320x999.png\",\n" +
                "            \"title\":\"新款韩版短袖拼接圆领修身T恤棉质简约显瘦学院风潮学生上衣\",\n" +
                "            \"price\":\"¥39.8\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"iid\":\"1kbwcv2\",\n" +
                "            \"url\":\"https://s5.mogucdn.com/mlcdn/c45406/200811_3ekk85jd9d6ahg20k48i8334ff202_750x1000.jpg_320x999.png\",\n" +
                "            \"title\":\"白色t恤女宽松韩版短袖2020年夏季中长款ins潮搭纯棉半袖\",\n" +
                "            \"price\":\"¥49\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"iid\":\"1kbwcv2\",\n" +
                "            \"url\":\"https://s11.mogucdn.com/mlcdn/c45406/200811_8afkiafb13g7711kal9l1d919hdb3_750x1000.jpg_320x999.png\",\n" +
                "            \"title\":\"2020夏季短袖t恤女露脐韩版新款高腰漏肚脐学生装短款上衣\",\n" +
                "            \"price\":\"¥39\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"iid\":\"1kbwcv2\",\n" +
                "            \"url\":\"https://s5.mogucdn.com/mlcdn/c45406/200814_3437j0917ejcla1ajd75k352kihaf_800x1200.jpg_320x999.png\",\n" +
                "            \"title\":\"2020早秋新款小心机设计感黑白撞色露肩纯棉假两件长袖T恤\",\n" +
                "            \"price\":\"¥59\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"iid\":\"1kbwcv2\",\n" +
                "            \"url\":\"https://s11.mogucdn.com/mlcdn/c45406/200811_0i8agkd57h5ihjh39j199jh1aj9j2_750x1000.jpg_320x999.png\",\n" +
                "            \"title\":\"韩版潮款夏季女装2020新款港风学生日系清新短袖露脐上衣女\",\n" +
                "            \"price\":\"¥39\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"iid\":\"1kbwcv2\",\n" +
                "            \"url\":\"https://s5.mogucdn.com/mlcdn/c45406/200807_4398kbe3ce8ij5a4dialhbh59bhd0_800x1200.jpg_320x999.png\",\n" +
                "            \"title\":\"夏装2020新款学院风V领体恤格子百褶裙修身复古方领上衣女\",\n" +
                "            \"price\":\"¥49\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"iid\":\"1kbwcv2\",\n" +
                "            \"url\":\"https://s11.mogucdn.com/mlcdn/c45406/190228_7bbgcii289k77797dd2c0097d54jg_800x1200.jpg_320x999.png\",\n" +
                "            \"title\":\"吊带背心女外穿打底衫内搭夏针织无袖t恤潮性感百搭运动黑色上衣\",\n" +
                "            \"price\":\"¥39\"\n" +
                "        }\n" +
                "    ]\n" +
                "}\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(result);
        if ("1kbwcv2".equals(iid)) {
            return new ResponseResult<JSONObject>(200, "获取数据成功", jsonObject);
        } else {
            return new ResponseResult<>(200, "获取数据成功", new JSONObject());
        }
    }
}
