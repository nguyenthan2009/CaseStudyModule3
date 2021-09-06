package service.player;

public class PlayerService {
  public   static final String SELECT_PLAYERDETAIL =  "select namePlayer,height,weight,bmiIndex,salary,address, bornYear from playerstats join player on playerstats.id_player= player.id  join user on player.id_user = user.id where user.id =?;";
}
