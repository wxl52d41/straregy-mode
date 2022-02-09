使用策略模式+工厂模式+枚举

在现实生活中常常遇到实现某种目标存在多种策略可供选择的情况，例如，出行旅游可以乘坐飞机、乘坐火车、骑自行车或自己开私家车等，超市促销可以釆用打折、送商品、送积分等方法。

在软件开发中也常常遇到类似的情况，当实现某一个功能存在多种算法或者策略，我们可以根据环境或者条件的不同选择不同的算法或者策略来完成该功能，如数据排序策略有冒泡排序、选择排序、插入排序、二叉树排序等。

如果使用多重条件转移语句实现（即硬编码），不但使条件语句变得很复杂，而且增加、删除或更换算法要修改原代码，不易维护，违背开闭原则。如果采用策略模式就能很好解决该问题。

# 策略模式的定义与特点

==策略（Strategy）模式的定义==：该模式定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，且算法的变化不会影响使用算法的客户。策略模式属于对象行为模式，它通过对算法进行封装，把使用算法的责任和算法的实现分割开来，并委派给不同的对象对这些算法进行管理。

==策略模式的主要优点如下==

```xml
1.多重条件语句不易维护，而使用策略模式可以避免使用多重条件语句，如 if...else 语句、switch...case 语句。
2.策略模式提供了一系列的可供重用的算法族，恰当使用继承可以把算法族的公共代码转移到父类里面，从而避免重复的代码。
3.策略模式可以提供相同行为的不同实现，客户可以根据不同时间或空间要求选择不同的。
4.策略模式提供了对开闭原则的完美支持，可以在不修改原代码的情况下，灵活增加新算法。
5.策略模式把算法的使用放到环境类中，而算法的实现移到具体策略类中，实现了二者的分离。
```

==其主要缺点如下==

```xml
1.客户端必须理解所有策略算法的区别，以便适时选择恰当的算法类。
2.策略模式造成很多的策略类，增加维护难度。
```

# 策略模式的结构与实现

策略模式是准备一组算法，并将这组算法封装到一系列的策略类里面，作为一个抽象策略类的子类。策略模式的重心不是如何实现算法，而是如何组织这些算法，从而让程序结构更加灵活，具有更好的维护性和扩展性，现在我们来分析其基本结构和实现方法。

## 1. 模式的结构

策略模式的主要角色如下。

```xml
1.抽象策略（Strategy）类：定义了一个公共接口，各种不同的算法以不同的方式实现这个接口，
  环境角色使用这个接口调用不同的算法，一般使用接口或抽象类实现。
2.具体策略（Concrete Strategy）类：实现了抽象策略定义的接口，提供具体的算法实现。
3.环境（Context）类：持有一个策略类的引用，最终给客户端调用。
```

其结构图如图 1 所示。

![策略模式的结构图](https://img-blog.csdnimg.cn/a3930fcc19af4dc180b95ca83199053f.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5LyP5Yqg54m56YGH5LiK6KW_5p-a,size_20,color_FFFFFF,t_70,g_se,x_16)

## 2. 模式的实现

策略模式的实现代码如下：

### 1、抽象策略类

```java
/**
 * 策略（Strategy） 策略是一个接口，该接口定义算法标识。
 * @author
 * @date 2020/5/4 18:07
 */
public interface Strategy {

    /**
     * 根据dataId生成报告
     *
     * @param dataId 数据id
     */
    void generatorReport(String dataId);
}
```
### 2、具体策略类
关注流程
```java
@Slf4j
@Service
@ProcessTypeEnumFlag(ProcessType.FOCUS_PROCESS)//自定义注解，标注该类为FOCUS_PROCESS
public class FocusProcessStrategyService implements Strategy {
    @Override
    public void generatorReport(String dataId) {
        log.info("生成关注报告,报告Id:[{}]", dataId);
    }
}
```
查询流程

```java
@Slf4j
@Service
@ProcessTypeEnumFlag(ProcessType.QUERY_PROCESS)//自定义注解，标注该类为QUERY_PROCESS
public class QueryProcessStrategyService implements Strategy {
    @Override
    public void generatorReport(String dataId) {
        log.info("生成查询报告,报告Id:[{}]",dataId);
    }
}
```
###  3、环境（Context）类
==环境类接口==

```java
public interface GeneratorContextService {
     void generatorContext(String dataId, ProcessType type);
}
```
==环境类实现==

```java
/**
 *上下文（Context）：上下文是依赖于策略接口的类，即上下文包含有策略声明的变量。
 * 上下文中提供了一个方法，该方法委托策略变量调用具体策略所实现的策略接口中的方法。
 */
@Service
public class GeneratorContextServiceImpl implements GeneratorContextService {

    @Override
    public void generatorContext(String dataId, ProcessType type) {
        Optional.ofNullable(ProcessTypeGeneratorReportConfig.generatorStrategyMap.get(type))
                .orElseThrow(() -> new RuntimeException("没有找到实现的bean" + this))
                .generatorReport(dataId);
    }
}
```
==策略映射==
```java
/**
 * 初始化策略map key-->策略枚举 value-->策略对应的具体实现
 * @author xlwang55
 */
@Component
public class ProcessTypeGeneratorReportConfig implements ApplicationContextAware, InitializingBean {

    public static Map<ProcessType, Strategy> generatorStrategyMap;

    private ApplicationContext applicationContext;

    private ProcessTypeGeneratorReportConfig() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        initGeneratorStrategyMap();
    }

    private void initGeneratorStrategyMap() {
        //获取所有关于Strategy的bean
        Map<String, Strategy> beanMap = applicationContext.getBeansOfType(Strategy.class);
        //策略枚举与具体策略实现关联(将标注了@ProcessTypeEnumFlag注解的类和枚举做关联)
        Map<ProcessType, Strategy> result = EnumBeanMapUtil.beanMap2EnumMap(beanMap, ProcessTypeEnumFlag.class,
                ProcessTypeEnumFlag::value);
        setGeneratorStrategyMap(result);
    }

    /**
     * @param generatorStrategyMap key枚举，value对应的实现
     * @return
     * @author xlwang55
     * @date 2022/2/9
     */
    private static void setGeneratorStrategyMap(Map<ProcessType, Strategy> generatorStrategyMap) {
        ProcessTypeGeneratorReportConfig.generatorStrategyMap = generatorStrategyMap;
    }


}
```
###  4、单元测试
```java
@Component
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StrategyServiceTest {
    @Autowired
    private GeneratorContextService generatorContextService;

    @Test
    public void testGeneratorReport() {
        generatorContextService.generatorContext("123", ProcessType.QUERY_PROCESS);
        generatorContextService.generatorContext("456", ProcessType.FOCUS_PROCESS);
    }
}
```
![运行结果](https://img-blog.csdnimg.cn/41b64846fde14d48bf52e78757f3a1e6.png)


参考：
[1、简单策略模式](https://www.runoob.com/design-pattern/strategy-pattern.html)
[2、枚举策略](https://github.com/BoomManPro/spring-enum-strategy-pattern)
