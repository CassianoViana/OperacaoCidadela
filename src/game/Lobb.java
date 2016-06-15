package game;

import java.io.Serializable;

public interface Lobb extends Serializable{

	void addPlayer(Player player);
        
        String getName();
        
        void start();
        
        void addListener(LobbListener listener);

}
