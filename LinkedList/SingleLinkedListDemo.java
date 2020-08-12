package 算法.LinkedList;

import java.net.http.HttpRequest;

public class SingleLinkedListDemo {
    public static void main(String[] args) {

        HeroNode hero1=new HeroNode(1,"aa");
        HeroNode hero2=new HeroNode(2,"bb");
        HeroNode hero3=new HeroNode(3,"cc");
        HeroNode hero4=new HeroNode(4,"dd");
        HeroNode hero5=new HeroNode(4,"嗨~");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
/*        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);*/
        singleLinkedList.addByNum(hero4);
        singleLinkedList.addByNum(hero2);
        singleLinkedList.addByNum(hero1);
        singleLinkedList.addByNum(hero3);

        //显示
        System.out.println("显示----------------");
        singleLinkedList.show();


        //查找
        System.out.println("查找----------------");
        singleLinkedList.findByNum(4);

        //修改
        System.out.println("修改----------------");
        singleLinkedList.updateByNum(hero5);

        //翻转
        System.out.println("翻转----------------");

        singleLinkedList.reverseList(singleLinkedList);
        singleLinkedList.show();


       /* //删除
        System.out.println("删除----------------");
        singleLinkedList.deleteByNum(2);*/
    }
}

//定义SingleLinkedList一个管理hero
class SingleLinkedList{
    //初始化一个头结点
    private HeroNode head=new HeroNode(0,"");
    //添加单向链表
    public void add(HeroNode hero){
        //因为头结点不能动，我们需要一个辅助遍历 temp
        HeroNode temp=head;
        while (true){
            //找到链表的最后
            if(temp.next==null){
                break;
            }
            //如果没有到最后则后移temp
            temp=temp.next;
        }
        temp.next=hero;
    }

    //按照编号顺序添加
    public void addByNum(HeroNode hero){
        //因为头结点不能动，我们需要一个辅助遍历 temp
        HeroNode temp=head;
        boolean flag=false;//用于判断是否nub重复
        while (true){
            if(temp.next==null){
                break;
            }
            if(hero.nub<temp.next.nub){
                break;
            }else if(hero.nub==temp.next.nub){//nub相等
                flag=true;
                break;
            }
             temp=temp.next;
        }
        if(flag){
            System.out.println("您添加的编号"+temp.nub+"已重复");
        }else {
            hero.next=temp.next;
            temp.next=hero;
        }
    }

    //按编号查找节点
    public  void findByNum(int num){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动，我们需要一个辅助遍历 temp
        HeroNode temp=head;
        while (true){
            if(temp.next==null){
                break;
            }
            if(temp.nub==num){
                break;
            }
        temp=temp.next;
        }
        if(temp.next==null&&temp.nub!=num){
            System.out.println("没找到您查询的信息");
        }else {
            System.out.println("找到啦！信息为===="+temp.toString());
        }
    }


    //按编号修改节点
    public  void updateByNum(HeroNode newHero){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动，我们需要一个辅助遍历 temp
        HeroNode temp=head;
        while (true){
            if(temp.next==null){
                break;
            }
            if(temp.next.nub==newHero.nub){
                break;
            }
            temp=temp.next;
        }

        if(temp.next==null){
            System.out.println("没找到您所要修改的信息");
        }else {
            temp.next=newHero;
            System.out.println("修改成功！新的信息为："+temp.next.toString());
            show();
        }

    }

    //删除节点
    public void deleteByNum(int num){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp=head;
        while (true){
            if(temp.next==null){
                break;
            }
            if(temp.next.nub==num){
                break;
            }
            temp=temp.next;
        }
        temp.next=temp.next.next;
        show();
    }


    //显示数据
    public  void show(){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头结点不能动，我们需要一个辅助遍历 temp
        HeroNode temp=head;
        while (true){
            //找到链表的最后
            if(temp.next==null){
                break;
            }
            //如果没有到最后则后移temp
            temp=temp.next;
            System.out.println(temp);
        }
    }

    //翻转单链表
    public static void reverseList(SingleLinkedList List){//头插法
        if(List.head.next==null||List.head.next.next==null){
            return;//为空或只有一个节点
        }
        HeroNode cur=List.head.next;
        HeroNode next=null;//保存原链表的next
        HeroNode reverseHead=new HeroNode(0,"");
        while (cur!=null){
            next=cur.next;//先将cur的下一个节点保存
            cur.next=reverseHead.next;//将cur的next指向第一个有数据的节点
            reverseHead.next=cur;//将第一个有数据的节点换成cur
            cur=next;//下移
        }
        List.head=reverseHead;
    }

}


//定义HeroNode,每个HeroNode对象就是一个节点
class HeroNode{
    public int nub;
    public String name;
    public HeroNode next;
    public HeroNode(int nub, String name) {
        this.nub = nub;
        this.name = name;
    }
    @Override
    public String toString() {
        return "HeroNode{" +
                "nub=" + nub +
                ", name='" + name + '\'' +
                '}';
    }
}


