package com.youliao.java4;

import java.util.Optional;

/**
 * @Author HedianTea
 * @Date 2022/4/21 14:23
 * @Version 1.0
 * @Description： 没有 Optional 会有什么问题
 */
public class WithoutOptionalDemo {
    /**
     * 我们来模拟一个实际的应用场景。小王第一天上班，领导老马就给他安排了一个任务，要他从数据库中根据会员 ID 拉取一个会员的姓名，
     * 然后将姓名打印到控制台。虽然是新来的，但这个任务难不倒小王，于是他花了 10 分钟写下了这段代码：
     */

    public static void main(String[] args) {
        Member mem = getMemberByIdFromDB();
        if (mem != null) {
            System.out.println(mem.getName());
        }

        Member member1 = new Member();
        member1.setName("张三");

        Optional<Member> member = Optional.ofNullable(mem);
        System.out.println(member);
    }

    static class Member {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    public WithoutOptionalDemo() {
    }

    public static Member getMemberByIdFromDB() {
        /*// 当前 ID 的会员不存在
        return null;*/
        Member member = new Member();
        member.setName("里斯");
        return member;
    }
}
