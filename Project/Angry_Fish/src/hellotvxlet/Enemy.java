package hellotvxlet;
//enemyscript
import java.awt.Image;
import java.util.Random;

public class Enemy extends Sprite{
    Image mijnimg;
    Random r;
    int richting = 1;
    EnemyRocket racket;
    Random r2;
    int rndm2 = 3;
    int y,x;
    
    public Enemy(int x, int y)
    {
       super(x,y);
       r = new Random();
       r2 = new Random();
    }
    
    public void update(int tijd) {
        Randomize();
        if(rndm2 > 118){
        switch (richting)
        {
            case 1: //left
                this.x = 720;
                this.y = 288;
                racket = new EnemyRocket(0,288,richting);
                break;
            case 2: //up
                this.x = 360;
                this.y = 576;
                racket = new EnemyRocket(360,0,richting);
                 break;
            case 3: //right
                this.x = 0;
                this.y = 288;
                racket = new EnemyRocket(720,288,richting);
                 break;
            case 4: //down
                this.x = 360;
                this.y = 0;
                racket = new EnemyRocket(360,576,richting);
                 break;
        }
            HelloTVXlet.getScene().add(racket);
            HelloTVXlet.getPublisher().register(racket);
    }
    }
    public void Randomize()
    {
        richting = r.nextInt(4-1+1)+1;
        rndm2 = r2.nextInt(120);
        
    }
}
