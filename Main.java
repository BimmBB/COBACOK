package game;

import java.lang.Math;

public class Main {
    public static void main(String[] args) {

        Hero[] listPlayer = new Hero[2];
        int role[] = new int[2];

        for (int i=0; i<2;i++){
            int randHero = ((int)(Math.random()*100)) %3;
//            System.out.println(randHero);

            int randLevel = ((int)(Math.random()*100)) %30;
//            System.out.println(randLevel);

            role[i]=randHero;
            if (randHero==0) {
                listPlayer[i] = new Mage(randLevel+1);
            }else if(randHero==1){
                listPlayer[i] = new Assassin(randLevel+1);
            }else if(randHero==2) {
                listPlayer[i] = new Tank(randLevel + 1);
            }
        }

        listPlayer[0].checkStatus();
        System.out.println("----------------------------------------");
        listPlayer[1].checkStatus();
        System.out.println("----------------------------------------");
//        fight

        int counter=0;
        while (listPlayer[0].healthPoint>=0 && listPlayer[1].healthPoint>=0){

            counter++;
            double hp = listPlayer[counter % 2].healthPoint-=listPlayer[(counter+1)%2].attackDamage;
            if (hp<=0){
                System.out.println("Player "+(((counter+1)%2)+1) + " Is Kalah");
                break;
            }

            System.out.println("Round "+counter);


            listPlayer[(counter-1)%2].spawnIntro();

            System.out.println("Player "+(counter)%2+" HP: "+hp);
            System.out.println("----------------------------------------");

        }





    }
}

buatlah program untuk pengecekan berdasarkan pengumpulan