package fr.upmc.dar.dao;

import fr.upmc.dar.dao.interfaces.IComment;
import fr.upmc.dar.dao.interfaces.IEventDao;
import fr.upmc.dar.dao.interfaces.IFriendsDao;
import fr.upmc.dar.dao.interfaces.IGroupDao;
import fr.upmc.dar.dao.interfaces.IUserDao;

public class DAOFactory {

	static UserDao userDao;
	static EventDao eventDao;
	static FriendsDao friendsDao;


	public static IUserDao createUserDao(){
		if ( userDao == null )
			return new UserDao();
		return userDao;
	}

	public static IEventDao createEventDao(){
		if ( eventDao == null )
			return new EventDao();
		return eventDao;
	}

	public static IGroupDao createGroupDao(){

		return new GroupDao();
	}
	
	public static IComment createUCommentDao(){

		return new CommentDao();
	}
	
	public static IFriendsDao createFriendDao(){
		if ( friendsDao == null )
			return new FriendsDao();
		return friendsDao;
	}
}
