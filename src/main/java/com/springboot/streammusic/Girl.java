package com.springboot.streammusic;

public class Girl {
    Outfit outfit;
    public Girl (Outfit outfit){
        this.outfit = outfit;
    }

    public void dressUp(){
        outfit.wear();
    }

}
