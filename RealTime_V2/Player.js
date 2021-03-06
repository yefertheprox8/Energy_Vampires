

function Player (id, nickname, score, team, socketId, lng, lat) { 
	this.playerId = id;
	this.nickname = nickname,
	this.lng = lng,
	this.lat = lat,
	this.score = score,
	this.team = team;
	this.socketId = socketId;
	this.state = 0;
}

Player.prototype.playerStates 	= {NOTREADY : 0, READY : 1, PLAYING : 2};


Player.prototype.addScore 			= function addScore(value){ this.score += value; };
Player.prototype.drainScore 		= function drainScore(value){ this.score -= value; };
Player.prototype.switchTeam 		= function switchTeam(team){ this.team = team; };
Player.prototype.updateLocation 	= function updateLocation(location){ this.lng = location.lng; this.lat = location.lat;};
Player.prototype.getLocationPoint	= function getLocationPoint(){return "{" + this.lng + "," + this.lat + "}";};

//getters and setters

Player.prototype.getId 			= function getId(){ return this.playerId; };
Player.prototype.getNickname 	= function getNickname(){ return this.nickname;	 };
Player.prototype.setNickname 	= function setNickname(value){ this.nickname = value; };
Player.prototype.getLng 		= function getLng(){ return this.lng; };
Player.prototype.getLat 		= function getLat(){ return this.lat; };
Player.prototype.getScore 		= function getScore(){ return this.score; };
Player.prototype.getTeam 		= function getTeam(){ return this.team; };
Player.prototype.getUsername 	= function getUsername(){ return this.username; };
Player.prototype.getSocketId 	= function getSocketId(){ return this.socketId; };







exports.Player = Player;