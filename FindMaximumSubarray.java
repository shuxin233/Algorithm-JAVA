package com;
/*
最大子数组问题
分治策略
*/
public class FindMaximumSubarray {

    public static void main(String[] args) {
        //待查数组
        int[] A={100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97};
        //简单处理成每一天股票变化的净值
        int[] B=new int[A.length-1];
        for(int i=0;i<A.length-1;i++){
            B[i]=A[i+1]-A[i];
        }
        int [] result=Find_Maximum_Subarray(B,0,B.length-1);

        System.out.println("low="+result[0]+"  high="+result[1]+"  sum="+result[2]);
    }

    //计算并返回最懂子数组中值的总和
    public static int[] Find_Max_Crossing_Subarray(int[] A,int low,int mid,int high){
        int left_sum=-1000;//定义左子数组的 累加和
        int sum=0;//中间变量
        int max_left=mid;//最大子数组边界的左坐标
        for(int i=mid;i>=low;i--){//从mid到low循环找出最大子数组，并记录左坐标
            sum=sum+A[i];
            if(sum>left_sum){
                left_sum=sum;
                max_left=i;//并记录左坐标
            }
        }
        int right_sum=-1000;///同理
        int max_right=mid;
        sum=0;
        for(int i=mid+1;i<=high;i++){
            sum=sum+A[i];
            if(sum>right_sum){
                right_sum=sum;
                max_right=i;
            }
        }
        int[] result={max_left,max_right,left_sum+right_sum};
        return result;
    }


//分治策略 真正返回结果
    public static int[] Find_Maximum_Subarray(int[] A,int low,int high){
        //倘若只有一个数据，直接返回
        if(low==high){
            int[] result={low,high,A[low]};
            return result;
        }else {
            int mid = (low + high) / 2;//取得low与high的中间值下限
            int left[]=Find_Maximum_Subarray(A, low, mid);//递归的求解左子数组中的最大子数组，返回的为结果数组{low,high,sum}
            int right[]=Find_Maximum_Subarray(A, mid+1, high);//递归的求解又子数组中的最大子数组,返回的为结果数组{low,high,sum}
            int cross[]=Find_Max_Crossing_Subarray(A,low,mid,high);//求解跨越中点的最大子数组,返回的为结果数组{low,high,sum}

            if(left[2]>=right[2]&&left[2]>=cross[2]){//若左子数组的sum最大，则直接返回结果
                return left;
            }
            if(right[2]>=left[2]&&right[2]>=cross[2]){//同理，右子数组
                return right;
            }else {//同理
                return cross;
            }
        }
    }

}




