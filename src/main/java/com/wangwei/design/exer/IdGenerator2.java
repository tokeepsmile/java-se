package com.wangwei.design.exer;

/**
 * @Author wangwei
 * @Date 2020/5/3 11:44 上午
 * @Version 1.0
 * 第一轮重构：提高代码的可读性
 * 第二轮重构：提高代码的可测试性
 * 第三轮重构：编写完善的单元测试
 * 第四轮重构：所有重构完成之后添加注释
 *
 * hostName 变量不应该被重复使用，尤其当这两次使用时的含义还不同的时候；
 * 将获取 hostName 的代码抽离出来，定义为 getLastfieldOfHostName() 函数；
 * 删除代码中的魔法数，比如，57、90、97、122；
 * 将随机数生成的代码抽离出来，定义为 generateRandomAlphameric() 函数；
 * generate() 函数中的三个 if 逻辑重复了，且实现过于复杂，我们要对其进行简化；
 * 对 IdGenerator 类重命名，并且抽象出对应的接口。
 */
public class IdGenerator2 {
}
