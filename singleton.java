public Class Singleton(){



    private static Singleton instance = null;


    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    
    public static void main(String[] args){
        Singleton singleton = Singleton.getInstance();
    }
}p