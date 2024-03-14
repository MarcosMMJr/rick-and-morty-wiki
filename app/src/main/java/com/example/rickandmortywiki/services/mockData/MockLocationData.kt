package com.example.rickandmortywiki.services.mockData

import com.example.rickandmortywiki.services.models.LocationModel
import com.example.rickandmortywiki.services.models.components.CharacterUrlModel

object MockLocationData {
    val locationsList = listOf<LocationModel>(
        //region Local 1 - Earth (C-137)
        LocationModel(
            id = 1,
            name = "Earth (C-137)",
            type = "Planet",
            dimension = "Dimension C-137",
            residents = listOf(
                CharacterUrlModel("https://rickandmortyapi.com/api/character/38"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/45"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/71"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/82"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/83"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/92"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/112"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/114"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/116"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/117"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/120"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/127"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/155"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/169"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/175"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/179"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/186"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/201"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/216"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/239"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/271"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/302"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/303"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/338"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/343"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/356"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/394")


            ),
            url = "https://rickandmortyapi.com/api/location/1",
            created = "2017-11-10T12:42:04.162Z"
        ),
        //endregion
        //region Local 2 - Abadango
        LocationModel(
            id = 2,
            name = "Abadango",
            type = "Cluster",
            dimension = "unknown",
            residents = listOf(
                CharacterUrlModel("https://rickandmortyapi.com/api/character/6")
            ),
            url = "https://rickandmortyapi.com/api/location/2",
            created = "2017-11-10T13:06:38.182Z"
        ),
        //endregion
        //region Local 3 - Citadel of Ricks
        LocationModel(
            id = 3,
            name = "Citadel of Ricks",
            type = "Space station",
            dimension = "unknown",
            residents = listOf(
                CharacterUrlModel("https://rickandmortyapi.com/api/character/8"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/14"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/15"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/18"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/21"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/22"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/27"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/42"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/43"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/44"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/48"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/53"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/56"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/61"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/69"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/72"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/73"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/74"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/77"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/78"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/85"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/86"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/95"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/118"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/119"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/123"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/135"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/143"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/152"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/164"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/165"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/187"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/200"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/206"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/209"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/220"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/229"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/231"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/235"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/267"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/278"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/281"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/283"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/284"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/285"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/286"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/287"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/288"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/289"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/291"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/295"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/298"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/299"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/322"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/325"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/328"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/330"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/345"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/359"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/366"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/378"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/385"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/392"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/461"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/462"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/463"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/464"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/465"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/466"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/472"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/473"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/474"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/475"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/476"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/477"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/478"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/479"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/480"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/481"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/482"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/483"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/484"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/485"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/486"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/487"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/488"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/489"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/2"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/1"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/801"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/802"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/803"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/804"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/805"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/806"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/810"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/811"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/812"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/819"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/820"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/818")
            ),
            url = "https://rickandmortyapi.com/api/location/3",
            created = "2017-11-10T13:08:13.191Z"
        ),
        //endregion
        //region Local 4 - Worldender's lair
        LocationModel(
            id = 4,
            name = "Worldender's lair",
            type = "Planet",
            dimension = "unknown",
            residents = listOf(
                CharacterUrlModel("https://rickandmortyapi.com/api/character/10"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/81"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/208"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/226"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/340"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/362"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/375"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/382"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/395")
            ),
            url = "https://rickandmortyapi.com/api/location/4",
            created = "2017-11-10T13:08:20.569Z"
        ),
        //endregion
        //region Local 5 - Anatomy Park
        LocationModel(
            id = 5,
            name = "Anatomy Park",
            type = "Microverse",
            dimension = "Dimension C-137",
            residents = listOf(
                CharacterUrlModel("https://rickandmortyapi.com/api/character/12"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/17"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/96"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/97"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/98"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/99"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/100"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/101"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/108"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/268"),
                CharacterUrlModel("https://rickandmortyapi.com/api/character/300")
            ),
            url = "https://rickandmortyapi.com/api/location/5",
            created = "2017-11-10T13:08:46.060Z"
        )
        //endregion



    )
}