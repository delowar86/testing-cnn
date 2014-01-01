package qa;

import java.util.Random;



public class CnnUtility {

    public String text = "China, Japan and the United States are continuing their tense standoff in Beijing's "
            + "disputed new air defense zone Friday -- a treacherous situation that both sides warn could lead to violence, intended or notTo this point,"
            + " a senior official in U.S. President Barack Obama's administration said Friday that commercial airlines are being told to abide by Beijing's call to notify it of plans to traverse the newly declared zone over the East China Sea, even if the U.S. government doesn't recognize itWe ..."
            + " are advising for safety reasons that they comply with notices to airmen, which FAA always advises, the official said.This advice reflects fears that the back-and-forth between the two sides could have unintended consequences involving not just opposing troops, but innocent civilians as well."
            + "It's a subtle change from two days earlier, when the State Department said the U.S. government generally expects that U.S. carriers operating internationally"
            + "comply with other countries' mandates, rather than directing them to.Whatever U.S. carriers do, two major Japanese airlines have refused to comply with China's declaration."
            + "Last Saturday, China unilaterally announced the creation of a Air Defense Identification Zone over several islands it and Japan have both claimed. The two countries have been sharply at odds over those isles, which are believed to be near"
            + " large reserves of natural resources.Tokyo rejected the new zone, as well as Beijing's insistence that aircraft entering it identify themselves and file flight plans. They were joined by South Korea and Washington, with Secretary of State John Kerry saying the move would "
            + "only increase tensions in the region and create risks of an incident.Since then, there's been no backing down.On Friday morning, for instance, China scrambled fighter jets after U.S. and Japanese military aircraft entered its disputed air defense zone, "
            + "according to a Chinese military official.Col. Shen Jinke, a Chinese air force spokesman, said in Beijing that the two U.S. and 10 Japanese aircraft were monitoring targets in the zone. He said the Chinese air force and navy were identifying and monitoring "
            + "all foreign warplanes in the zone.A U.S. military official told CNN that at least one U.S. unarmed military aircraft and several Japanese military aircraft flew through the zone Friday without incident. The official said the U.S. flight was part of scheduled routine operations.";

    public String randomText(){

        String [] words = new String[11];
        words[0] = "politics";
        words[1] = "money";
        words[2] = "new york";
        words[3] = "world";
        words[4] = "economy";
        words[5] = "japan";
        words[6] = "germany";
        words[7] = "baseball";
        words[8] = "cold weather";
        words[9] = "obama";
        words[10] = "paris";

        String text = "";
        Random random = new Random();
        int randomText = random.nextInt(10)+1;
        for(int i=0; i<words.length; i++){
            text = words[randomText];
            randomText = random.nextInt(10)+1;
        }
        return text;
    }

} 