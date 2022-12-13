package com.saul.datastructure.digui;

/**
 * @author 枫伦
 * @DESCRIPTION 递归的有趣应用
 * @create 2021/9/23 8:14 下午
 */
public class FunnyUseRecurisionDemo {
    /**
     * ①、求一个数的乘方
     * 　　一般稍微复杂一点的计算器上面都能求一个数的乘法，通常计算器上面的标志是 x^y 这样的按键，表示求 x 的 y 次方。一般情况下我们是如何求一个数的乘法的呢？
     * <p>
     * 　　比如2^8,我们可以会求表达式2*2*2*2*2*2*2*2 的值，但是如果y的值很大，这个会显得表达式很冗长。那么由没有更快一点方法呢？
     * <p>
     * 　　数学公式如下是成立的：
     * <p>
     * 　　(Xa)b = Xa*b
     * <p>
     * 　　如果如果求28次方，我们可以先假定22=a,于是28 = （22）4 ，那么就是a4 ；假定 a2 = b，那么 a4 = b2，而b2可以写成(b2)1。于是现在28就转换成：b*b
     * <p>
     * 　　也就是说我们将乘方的运算转换为乘法的运算。
     * <p>
     * 　　求xy的值，当y是偶数的时候，最后能转换成两个数相乘，当时当y是奇数的时候，最后我们必须要在返回值后面额外的乘以一个x。
     * <p>
     * 1
     * x^y= (x^2)^(y/2)，定义a=x^2,b=y/2, 则得到形如： x^y= a^b;
     */
    public static int pow(int x, int y) {
        if (x == 0 || x == 1) {
            return x;
        }
        if (y > 1) {
            int b = y / 2;
            int a = x * x;
            if (y % 2 == 1) {//y为奇数
                return pow(a, b) * x;
            } else {//y为偶数
                return pow(a, b);
            }
        } else if (y == 0) {
            return 1;
        } else {//y==1
            return x;
        }
    }

    /**
     * ②、背包问题
     * 　　背包问题也是计算机中的经典问题。在最简单的形式中，包括试图将不同重量的数据项放到背包中，以使得背包最后达到指定的总重量。
     * <p>
     * 　　比如：假设想要让背包精确地承重20磅，并且有 5 个可以放入的数据项，它们的重量分别是 11 磅，8 磅，7 磅，6 磅，5 磅。这个问题可能对于人类来说很简单，我们大概就可以计算出 8 磅+ 7 磅 + 5 磅 = 20 磅。但是如果让计算机来解决这个问题，就需要给计算机设定详细的指令了。
     * <p>
     * 　　算法如下：
     * <p>
     * 　　一、如果在这个过程的任何时刻，选择的数据项的总和符合目标重量，那么工作便完成了。
     * <p>
     * 　　二、从选择的第一个数据项开始，剩余的数据项的加和必须符合背包的目标重量减去第一个数据项的重量，这是一个新的目标重量。
     * <p>
     * 　　三、逐个的试每种剩余数据项组合的可能性，但是注意不要去试所有的组合，因为只要数据项的和大于目标重量的时候，就停止添加数据。
     * <p>
     * 　　四、如果没有合适的组合，放弃第一个数据项，并且从第二个数据项开始再重复一遍整个过程。
     * <p>
     * 　　五、继续从第三个数据项开始，如此下去直到你已经试验了所有的组合，这时才知道有没有解决方案。
     * <p>
     * <p>
     */
    public static class Knapsack {
        private int[] weights; //可供选择的重量
        private boolean[] selects; //记录是否被选择

        public Knapsack(int[] weights) {
            this.weights = weights;
            selects = new boolean[weights.length];
        }

        /**
         * 找出符合承重重量的组合
         *
         * @param total 总重量
         * @param index 可供选择的重量下标
         */
        public void knapsack(int total, int index) {
            if (total < 0 || total > 0 && index >= weights.length) {
                return;//没找到解决办法，直接返回
            }
            if (total == 0) {//总重量为0，则找到解决办法了
                for (int i = 0; i < index; i++) {
                    if (selects[i] == true) {
                        System.out.println(weights[i] + " ");
                    }
                }
                System.out.println();
                return;
            }
            selects[index] = true;
            knapsack(total - weights[index], index + 1);
            selects[index] = false;
            knapsack(total, index + 1);
        }
    }

    public static void main(String[] args) {
        int array[] = {11, 9, 7, 6, 5};
        int total = 20;
        Knapsack k = new Knapsack(array);
        k.knapsack(total, 0);
    }
}
