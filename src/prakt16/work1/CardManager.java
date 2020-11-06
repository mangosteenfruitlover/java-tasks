package prakt16.work1;

import java.util.Scanner;

public class CardManager{
    public int triesAmount=0;
    public int cardsAmount;

    private Deck firstPlayerDeck=new Deck();
    private Deck secondPlayerDeck=new Deck();
    private Deck extraDeck=new Deck();


    public CardManager(int cardsAmount){
        this.cardsAmount=cardsAmount;
    }

    public void setCards(Scanner scanner,Deck playerDeck){
        for(int i=0;i<cardsAmount;i++){
            extraDeck.push(scanner.nextInt());
        }

        for(int i=0;i<cardsAmount;i++){
            playerDeck.push(extraDeck.pop());
        }
    }

    public void peekCard(Deck firstPlayerDeck,Deck secondPlayerDeck){
        if(checkDidSomeoneWon(firstPlayerDeck,secondPlayerDeck)){
            return;
        }else if(triesAmount==106){
            System.out.println("botva");
        }else{
            Deck extraFirstPlayer=new Deck();
            Deck extraSecondPlayer=new Deck();

            int cardsAmount=Math.min(firstPlayerDeck.size(),secondPlayerDeck.size());

            for(int i=0;i<cardsAmount;i++){
                if(firstPlayerDeck.peek()==0&&secondPlayerDeck.peek()==9){
                    extraFirstPlayer.push(firstPlayerDeck.pop());
                    extraFirstPlayer.push(secondPlayerDeck.pop());
                }else if(firstPlayerDeck.peek()==9&&secondPlayerDeck.peek()==0){
                    extraSecondPlayer.push(firstPlayerDeck.pop());
                    extraSecondPlayer.push(secondPlayerDeck.pop());
                }else if(firstPlayerDeck.peek()>secondPlayerDeck.peek()){
                    extraFirstPlayer.push(firstPlayerDeck.pop());
                    extraFirstPlayer.push(secondPlayerDeck.pop());
                }else if(secondPlayerDeck.peek()>firstPlayerDeck.peek()){
                    extraSecondPlayer.push(firstPlayerDeck.pop());
                    extraSecondPlayer.push(secondPlayerDeck.pop());
                }else{
                    extraFirstPlayer.push(firstPlayerDeck.pop());
                    extraSecondPlayer.push(secondPlayerDeck.pop());
                }
                triesAmount++;
            }

            Deck extra=new Deck();

            for(int i=0;i<firstPlayerDeck.size();i++){
                extra.push(firstPlayerDeck.pop());
            }

            for(int i=0;i<extra.size();i++){
                firstPlayerDeck.push(extra.pop());
            }

            for(int i=0;i<secondPlayerDeck.size();i++){
                extra.push(secondPlayerDeck.pop());
            }

            for(int i=0;i<extra.size();i++){
                secondPlayerDeck.push(extra.pop());
            }

            peekCard(extraFirstPlayer,extraSecondPlayer);
        }
    }

    private boolean checkDidSomeoneWon(Deck firstPlayerDeck,Deck secondPlayerDeck){
        String whoWon=null;

        if(firstPlayerDeck.size()==0){
            whoWon="second";
        }else if(secondPlayerDeck.size()==0){
            whoWon="first";
        }

        if(whoWon==null){
            return false;
        }else{
            System.out.println(whoWon+" "+triesAmount);
            return true;
        }
    }

    public Deck getFirstPlayerDeck(){
        return this.firstPlayerDeck;
    }

    public Deck getSecondPlayerDeck(){
        return this.secondPlayerDeck;
    }


    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        CardManager cardManager;

        System.out.println("Enter cards amount per deck:");
        cardManager=new CardManager(scanner.nextInt());

        cardManager.setCards(scanner,cardManager.getFirstPlayerDeck());
        cardManager.setCards(scanner,cardManager.getSecondPlayerDeck());

        cardManager.peekCard(cardManager.getFirstPlayerDeck(),cardManager.getSecondPlayerDeck());
    }
}

