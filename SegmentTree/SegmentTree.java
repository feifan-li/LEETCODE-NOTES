package SegmentTree;

public class SegmentTree {
    public class Node{
        public int l=-1,r=-1,mx=-inf;
    }
    int inf = Integer.MAX_VALUE;
    int[] a;
    Node[] tree;//4倍空间
    public SegmentTree(int[] nums){
        this.a = new int[nums.length+1];
        for(int i=1;i<= nums.length;++i){
            a[i] = nums[i-1];
        }
        this.tree = new Node[a.length*4];
        for(int i=1;i< tree.length;++i){
            tree[i] = new Node();
        }
        build(1,1,nums.length);
    }
    void build(int k,int l,int r){//创建线段树 k表示节点在tree[]中的存储下标 区间[l,r]
        this.tree[k].l = l;
        this.tree[k].r = r;
        if(l==r){//leaf
            tree[k].mx = a[l];
            return;
        }
        int mid = l+(r-l)/2;
        build(2*k,l,mid);//left child, at 2*k
        build(2*k+1,mid+1,r);//right child, at 2*k+1
        tree[k].mx = Math.max(tree[2*k].mx,tree[2*k+1].mx);
    }
    void update(int k,int i,int v){//点更新 将a[i]修改更新为v
        if(tree[k].l==tree[k].r && tree[k].l==i){
            tree[k].mx = v;
            return;
        }
        int mid = (tree[k].l+tree[k].r)/2;
        if (i<=mid){update(2*k,i,v);}
        else{update(2*k+1,i,v);}
        tree[k].mx = Math.max(tree[2*k].mx,tree[2*k+1].mx);//回归时更新最值
    }
    int query1(int k,int l, int r){//区间覆盖法, 求区间[l,...,r]的最值
        if(tree[k].l>=l && tree[k].r<=r){//区间覆盖
            return tree[k].mx;
        }
        int mid = (tree[k].l+tree[k].r)/2;
        int Max = -inf;//必须是局部变量
        if(l<=mid) Max = Math.max(Max,query1(2*k,l,r));//l, r 是不变的
        if(r>mid) Max = Math.max(Max,query1(2*k+1,l,r));
        return Max;
    }
    int query2(int k,int l, int r){//区间相等法, 求区间[l,...,r]的最值
        if(tree[k].l==l && tree[k].r==r){//区间相等
            return tree[k].mx;
        }
        int mid = (tree[k].l+tree[k].r)/2;
        if(r<=mid) return query2(2*k,l,r);//完全在左子树
        else if(l>mid) return query2(2*k+1,l,r);//完全在右子树
        else return Math.max(query2(2*k,l,mid),query2(2*k+1,mid+1,r));//左右子树分别查询
    }
    void printTree(){
        for(int i=1;i< tree.length;++i){
            if(tree[i].l!=-1 && tree[i].r!=-1){
                System.out.println("["+tree[i].l+","+tree[i].r+"] :"+"max = "+tree[i].mx);
            }
        }
    }
}
