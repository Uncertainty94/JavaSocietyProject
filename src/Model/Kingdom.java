package Model;

/**
 * Государство . Весь мир собственно.
 */
public class Kingdom
{
    /**Окружающая среда (поля, лес, замок, рынок...).**/
    Habitat _settlement;
    /** Словарь персонажей(ключ = ID, значение = IPerson).**/
    private  Dictionary<int, Person> _settlers = new Dictionary<int, Person>();
    public Kingdom(int countOfSettlers, int drawAreaWidht, int drawAreaHeight)
    {

        _settlement = new Habitat(_settlers, drawAreaWidht, drawAreaHeight);
        PersonFactory factory = new PersonFactory(_settlement);
        for (int i = 0; i <= countOfSettlers; i++)
        {
            Person man = factory.GetMan();
            _settlers.Add(i, man);
        }
        _settlement.RefreshLocation(_settlers);
    }
    /** Получиьт ссылку на персонажа с заданным ID.**/
    public Person GetCharacter(int id)
    {
        return _settlers[id];
    }
    /** Получить словарь ID-IPerson всех персонажей мира.**/
    public Dictionary<int, Person> GetDictionaryOfCharacters()
    {
        return _settlers;
    }
    /** Получить контейнер окружающей среды. **/
    public Habitat GetHabitat()
    {
        return _settlement;
    }
}

}
