package demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Table(name="VIDEO_GAME")
@ToString(of = { "id", "name", "gameGenre" })
@NoArgsConstructor
public class VideoGame implements Serializable
{
	@GeneratedValue
	@Id
	@Getter
	private Long id;

	@Getter
	@Setter
	private String name;

	@Enumerated(EnumType.STRING)
	@Getter
	@Setter
	@Column(name="GAME_GENRE")
	private GameGenre gameGenre;

	public VideoGame(String name, GameGenre gameGenre)
	{
		super();
		this.name = name;
		this.gameGenre = gameGenre;
	}

}
