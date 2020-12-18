class Animal {
    int num = 10;

    public void eat() {
        System.out.println("动物吃饭");
    }
}

class Cat extends Animal{
    int num = 20;

    @Override
    public void eat(){
        System.out.println("猫吃鱼");
    }
}

 class Test11 {
    public static void main(String[] args){
        Animal a = new Cat();
        System.out.println(a.num);
        a.eat();
    }
}