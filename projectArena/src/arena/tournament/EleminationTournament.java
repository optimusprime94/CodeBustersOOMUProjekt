///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package arena.tournament;
//import arena.users.Player;
///**
// *
// * @author S153977
// */
//public class EleminationTournament extends Tournament
//{
//    private Game game;
//    public EleminationTournament(Game game)
//    {
//        this.numberOfPlayers = 0;
//        this.maxNumberOfPlayers = 4;   
//        this.nextID = 0;
//        this.players = new Player[4];
//        
//    }
//    @Override
//    public void runTournament()
//    {
//        if (maxNumberOfPlayers != numberOfPlayers)
//        {
//            System.out.print("not enough players");
//        }
//        else
//        {
//            Scheme scheme = new Scheme(this.players);
//            while (scheme.moreGameExist())
//            {
//                game = scheme.getNextMatch();
//                game.play();
//            }
//        }
//    }
//    
//    public Player getWinner()
//    {
//        
//    }
//      
//    public class Scheme
//    {
//        private Game[] matches;
//        private Player[] players;
//        private Player winner;
//        
//        public Scheme(Player [] players)
//        {
//            this.players = players;
//            
//        }
//        public Game getNextMatch()
//        {
//            
//        }
//        public update(int matchID, Player winner)
//        {
//            
//        }
//        public boolean moreGameExist()
//        {
//            
//        }
//       
//    }
//   
//}
