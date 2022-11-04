package com.example.androidmovie.utils

import com.example.androidmovie.data.source.local.entity.DetailMovieEntity
import com.example.androidmovie.data.source.local.entity.DetailTvShowsEntity
import com.example.androidmovie.data.source.local.entity.MovieEntity
import com.example.androidmovie.data.source.local.entity.TvShowsEntity
import java.util.ArrayList

object DataMoviesDummy {
    fun generateMovies(): ArrayList<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        val actors1 = ArrayList<String>()
        val strActors1 = "Bradley Cooper, Lady Gaga, Sam Elliott"
        for (actor in strActors1.split(",")) {
            actors1.add(actor)
        }
        val actors2 = ArrayList<String>()
        val strActors2 = "Rosa Salazar, Christoph Waltz, Jennifer Connelly"
        for (actor in strActors2.split(",")) {
            actors2.add(actor)
        }
        val actors3 = ArrayList<String>()
        val strActors3 = "Jason Momoa, Amber Heard, Willem Dafoe"
        for (actor in strActors3.split(",")) {
            actors3.add(actor)
        }
        val actors4 = ArrayList<String>()
        val strActors4 = "Rami Malek, Gwilym Lee, Ben Hardy"
        for (actor in strActors4.split(",")) {
            actors4.add(actor)
        }
        val actors5 = ArrayList<String>()
        val strActors5 = "Liam Neeson, Laura Dern, Emmy Rossum"
        for (actor in strActors5.split(",")) {
            actors5.add(actor)
        }
        val actors6 = ArrayList<String>()
        val strActors6 = "Michael B. Jordan, Sylvester Stallone, Tessa Thompson"
        for (actor in strActors6.split(",")) {
            actors6.add(actor)
        }
        val actors7 = ArrayList<String>()
        val strActors7 = "Michael B. Jordan, Sylvester Stallone, Tessa Thompson"
        for (actor in strActors7.split(",")) {
            actors7.add(actor)
        }
        val actors8 = ArrayList<String>()
        val strActors8 = "James McAvoy, Bruce Willis, Samuel L. Jackson"
        for (actor in strActors8.split(",")) {
            actors8.add(actor)
        }
        val actors9 = ArrayList<String>()
        val strActors9 = "Jay Baruchel, Gerard Butler, Craig Ferguson"
        for (actor in strActors9.split(",")) {
            actors9.add(actor)
        }
        val actors10 = ArrayList<String>()
        val strActors10 = "Robert Downey Jr., Chris Hemsworth, Mark Ruffalo"
        for (actor in strActors10.split(",")) {
            actors10.add(actor)
        }

        movies.add(
            MovieEntity(
                "mv1",
                "A Star Is Born",
                strActors1,
                "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
                "05/10/2018",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
            )
        )
        movies.add(
            MovieEntity(
                "mv2",
                "Alita: Battle Angel",
                strActors2,
                "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
                "14/02/2019",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
            )
        )
        movies.add(
            MovieEntity(
                "mv3",
                "Aquaman",
                strActors3,
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "26/12/2018",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
            )
        )
        movies.add(
            MovieEntity(
                "mv4",
                "Bohemian Rhapsody",
                strActors4,
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "30/10/2018",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
            )
        )
        movies.add(
            MovieEntity(
                "mv5",
                "Cold Pursuit",
                strActors5,
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "08/02/2019",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
            )
        )
        movies.add(
            MovieEntity(
                "mv6",
                "Creed",
                strActors6,
                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
                "25/11/2015",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iBq4od6j1ZAvDVO7hwmHT2Xf2Bt.jpg",
            )
        )
        movies.add(
            MovieEntity(
                "mv7",
                "Fantastic Beasts: The Crimes of Grindelwald",
                strActors7,
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "16/11/2018",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
            )
        )
        movies.add(
            MovieEntity(
                "mv8",
                "Glass",
                strActors8,
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "18/01/2019",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
            )
        )
        movies.add(
            MovieEntity(
                "mv9",
                "How to Train Your Dragon",
                strActors9,
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                "26/03/2010",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ygGmAO60t8GyqUo9xYeYxSZAR3b.jpg",
            )
        )
        movies.add(
            MovieEntity(
                "mv10",
                "Avengers: Infinity War",
                strActors10,
                "Karena Avengers dan sekutunya terus melindungi dunia dari ancaman yang terlalu besar untuk ditangani oleh seorang pahlawan, bahaya baru telah muncul dari bayangan kosmik: Thanos. Seorang lalim penghujatan intergalaksi, tujuannya adalah untuk mengumpulkan semua enam Batu Infinity, artefak kekuatan yang tak terbayangkan, dan menggunakannya untuk menimbulkan kehendak memutar pada semua realitas. Segala sesuatu yang telah diperjuangkan oleh Avengers telah berkembang hingga saat ini - nasib Bumi dan keberadaannya sendiri tidak pernah lebih pasti.",
                "27/04/2018",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
            )
        )
        return movies
    }

    fun generateTvShows(): ArrayList<TvShowsEntity> {
        val tvShows = ArrayList<TvShowsEntity>()
        val actors1 = ArrayList<String>()
        val strActors1 = "Stephen Amell, David Ramsey, Emily Bett Rickards"
        for (actor in strActors1.split(",")) {
            actors1.add(actor)
        }
        val actors2 = ArrayList<String>()
        val strActors2 = "Diane Guerrero, April Bowlby, Joivan Wade"
        for (actor in strActors2.split(",")) {
            actors2.add(actor)
        }
        val actors3 = ArrayList<String>()
        val strActors3 = "Masako Nozawa, Yuko Minaguchi, Hiroko Emori"
        for (actor in strActors3.split(",")) {
            actors3.add(actor)
        }
        val actors4 = ArrayList<String>()
        val strActors4 = "Makoto Furukawa, Wataru Hatano, Aya Hirano"
        for (actor in strActors4.split(",")) {
            actors4.add(actor)
        }
        val actors5 = ArrayList<String>()
        val strActors5 = "Seth MacFarlane, Alex Borstein, Seth Green"
        for (actor in strActors5.split(",")) {
            actors5.add(actor)
        }
        val actors6 = ArrayList<String>()
        val strActors6 = "John Wesley Shipp, Amanda Pays, Alex Désert"
        for (actor in strActors6.split(",")) {
            actors6.add(actor)
        }
        val actors7 = ArrayList<String>()
        val strActors7 = "Ben McKenzie, Donal Logue, David Mazouz"
        for (actor in strActors7.split(",")) {
            actors7.add(actor)
        }
        val actors8 = ArrayList<String>()
        val strActors8 = "Sarkis Ninos, Rushi Kota, Jaicy Elliot"
        for (actor in strActors8.split(",")) {
            actors8.add(actor)
        }
        val actors9 = ArrayList<String>()
        val strActors9 = "Esme Creed-Miles, Mireille Enos, Dermot Mulroney"
        for (actor in strActors9.split(",")) {
            actors9.add(actor)
        }
        val actors10 = ArrayList<String>()
        val strActors10 = "Finn Jones, Jessica Henwick, Jessica Stroup"
        for (actor in strActors10.split(",")) {
            actors10.add(actor)
        }

        tvShows.add(
            TvShowsEntity(
                "tv1",
                "The Arrow",
                strActors1,
                "Panah adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow",
                "2012",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
            )
        )
        tvShows.add(
            TvShowsEntity(
                "tv2",
                "Doom Patrol",
                strActors2,
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "2019",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/kOAn06LmRCg4YiSStwrGL6UOQ3a.jpg",
            )
        )
        tvShows.add(
            TvShowsEntity(
                "tv3",
                "Dragon Ball Z",
                strActors3,
                "After learning that he is from another planet, a warrior named Goku and his friends are prompted to defend it from an onslaught of extraterrestrial enemies.",
                "1989",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6VKOfL6ihwTiB5Vibq6QTfzhxA6.jpg",
            )
        )
        tvShows.add(
            TvShowsEntity(
                "tv4",
                "Fairy Tail: Dragon Cry",
                strActors4,
                "Natsu Dragneel and his friends travel to the island Kingdom of Stella, where they will reveal dark secrets, fight the new enemies and once again save the world from destruction.",
                "2017",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4CtvjdvuRj3iPlvtpvFomhTxjXR.jpg",
            )
        )
        tvShows.add(
            TvShowsEntity(
                "tv5",
                "Family Guy",
                strActors5,
                "Seri animasi animasi Freakin 'Sweet yang sakit, terpelintir, dan salah, menampilkan petualangan keluarga Griffin yang disfungsional. Peter yang kikuk dan Lois yang sudah lama menderita memiliki tiga anak. Stewie (bayi yang brilian tetapi sadis yang bertekad membunuh ibunya dan mengambil alih dunia), Meg (yang tertua, dan merupakan gadis yang paling tidak populer di kota) dan Chris (anak tengah, dia tidak terlalu cerdas tetapi memiliki hasrat untuk film ). Anggota terakhir keluarga itu adalah Brian - anjing yang bisa bicara dan lebih dari sekadar hewan peliharaan, ia menjaga Stewie, sementara menghirup Martinis dan memilah-milah masalah hidupnya sendiri.",
                "1999",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9RBeCo8QSaoJLmmuzlwzVH3Hi12.jpg",
            )
        )
        tvShows.add(
            TvShowsEntity(
                "tv6",
                "The Flash",
                strActors6,
                "When a bolt of lightening crashes through a police crime lab, a mix of electrically charged substances bathes chemist Barry Allen, transforming him into the fastest man alive--The Flash.",
                "1990",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fi1GEdCbyWRDHpyJcB25YYK7fh4.jpg",
            )
        )
        tvShows.add(
            TvShowsEntity(
                "tv7",
                "Gotham",
                strActors7,
                "Semua orang tahu nama Komisaris Gordon. Dia adalah salah satu musuh terbesar dunia kejahatan, seorang pria yang reputasinya identik dengan hukum dan ketertiban. Tapi apa yang diketahui tentang kisah Gordon dan kenaikannya dari detektif pemula ke Komisaris Polisi? Apa yang diperlukan untuk menavigasi berbagai lapisan korupsi yang diam-diam memerintah Kota Gotham, tempat bertelurnya penjahat paling ikonik di dunia? Dan keadaan apa yang menciptakan mereka - persona yang lebih besar dari kehidupan yang akan menjadi Catwoman, The Penguin, The Riddler, Two-Face dan The Joker?",
                "2014",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
            )
        )
        tvShows.add(
            TvShowsEntity(
                "tv8",
                "Grey's Anatomy: B-Team",
                strActors8,
                "New interns' tackle their first day as surgeons at Grey Sloan Memorial under the watchful and stern eye of Chief Bailey.",
                "2018",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/s0FZu5JBH1OdH5kIVfck3c2DpkC.jpg",
            )
        )
        tvShows.add(
            TvShowsEntity(
                "tv9",
                "Hanna",
                strActors9,
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "2019",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pe10EUjgO2jgwiu01MAv9l3IjxG.jpg",
            )
        )
        tvShows.add(
            TvShowsEntity(
                "tv10",
                "Marvel's Iron Fist",
                strActors10,
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "2017",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4l6KD9HhtD6nCDEfg10Lp6C6zah.jpg",
            )
        )
        return tvShows
    }

    fun generateDetailMovies(): ArrayList<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        val actors1 = ArrayList<String>()
        val strActors1 = "Bradley Cooper, Lady Gaga, Sam Elliott"
        for (actor in strActors1.split(",")) {
            actors1.add(actor)
        }
        val actors2 = ArrayList<String>()
        val strActors2 = "Rosa Salazar, Christoph Waltz, Jennifer Connelly"
        for (actor in strActors2.split(",")) {
            actors2.add(actor)
        }
        val actors3 = ArrayList<String>()
        val strActors3 = "Jason Momoa, Amber Heard, Willem Dafoe"
        for (actor in strActors3.split(",")) {
            actors3.add(actor)
        }
        val actors4 = ArrayList<String>()
        val strActors4 = "Rami Malek, Gwilym Lee, Ben Hardy"
        for (actor in strActors4.split(",")) {
            actors4.add(actor)
        }
        val actors5 = ArrayList<String>()
        val strActors5 = "Liam Neeson, Laura Dern, Emmy Rossum"
        for (actor in strActors5.split(",")) {
            actors5.add(actor)
        }
        val actors6 = ArrayList<String>()
        val strActors6 = "Michael B. Jordan, Sylvester Stallone, Tessa Thompson"
        for (actor in strActors6.split(",")) {
            actors6.add(actor)
        }
        val actors7 = ArrayList<String>()
        val strActors7 = "Michael B. Jordan, Sylvester Stallone, Tessa Thompson"
        for (actor in strActors7.split(",")) {
            actors7.add(actor)
        }
        val actors8 = ArrayList<String>()
        val strActors8 = "James McAvoy, Bruce Willis, Samuel L. Jackson"
        for (actor in strActors8.split(",")) {
            actors8.add(actor)
        }
        val actors9 = ArrayList<String>()
        val strActors9 = "Jay Baruchel, Gerard Butler, Craig Ferguson"
        for (actor in strActors9.split(",")) {
            actors9.add(actor)
        }
        val actors10 = ArrayList<String>()
        val strActors10 = "Robert Downey Jr., Chris Hemsworth, Mark Ruffalo"
        for (actor in strActors10.split(",")) {
            actors10.add(actor)
        }

        movies.add(
            MovieEntity(
                "mv1",
                "A Star Is Born",
                strActors1,
                "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
                "05/10/2018",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
            )
        )
        movies.add(
            MovieEntity(
                "mv2",
                "Alita: Battle Angel",
                strActors2,
                "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
                "14/02/2019",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
            )
        )
        movies.add(
            MovieEntity(
                "mv3",
                "Aquaman",
                strActors3,
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "26/12/2018",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
            )
        )
        movies.add(
            MovieEntity(
                "mv4",
                "Bohemian Rhapsody",
                strActors4,
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "30/10/2018",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
            )
        )
        movies.add(
            MovieEntity(
                "mv5",
                "Cold Pursuit",
                strActors5,
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "08/02/2019",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
            )
        )
        movies.add(
            MovieEntity(
                "mv6",
                "Creed",
                strActors6,
                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
                "25/11/2015",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iBq4od6j1ZAvDVO7hwmHT2Xf2Bt.jpg",
            )
        )
        movies.add(
            MovieEntity(
                "mv7",
                "Fantastic Beasts: The Crimes of Grindelwald",
                strActors7,
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "16/11/2018",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
            )
        )
        movies.add(
            MovieEntity(
                "mv8",
                "Glass",
                strActors8,
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "18/01/2019",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
            )
        )
        movies.add(
            MovieEntity(
                "mv9",
                "How to Train Your Dragon",
                strActors9,
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                "26/03/2010",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ygGmAO60t8GyqUo9xYeYxSZAR3b.jpg",
            )
        )
        movies.add(
            MovieEntity(
                "mv10",
                "Avengers: Infinity War",
                strActors10,
                "Karena Avengers dan sekutunya terus melindungi dunia dari ancaman yang terlalu besar untuk ditangani oleh seorang pahlawan, bahaya baru telah muncul dari bayangan kosmik: Thanos. Seorang lalim penghujatan intergalaksi, tujuannya adalah untuk mengumpulkan semua enam Batu Infinity, artefak kekuatan yang tak terbayangkan, dan menggunakannya untuk menimbulkan kehendak memutar pada semua realitas. Segala sesuatu yang telah diperjuangkan oleh Avengers telah berkembang hingga saat ini - nasib Bumi dan keberadaannya sendiri tidak pernah lebih pasti.",
                "27/04/2018",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
            )
        )
        return movies
    }

    fun generateDetailTvShows(): ArrayList<TvShowsEntity> {
        val tvShows = ArrayList<TvShowsEntity>()
        val actors1 = ArrayList<String>()
        val strActors1 = "Stephen Amell, David Ramsey, Emily Bett Rickards"
        for (actor in strActors1.split(",")) {
            actors1.add(actor)
        }
        val actors2 = ArrayList<String>()
        val strActors2 = "Diane Guerrero, April Bowlby, Joivan Wade"
        for (actor in strActors2.split(",")) {
            actors2.add(actor)
        }
        val actors3 = ArrayList<String>()
        val strActors3 = "Masako Nozawa, Yuko Minaguchi, Hiroko Emori"
        for (actor in strActors3.split(",")) {
            actors3.add(actor)
        }
        val actors4 = ArrayList<String>()
        val strActors4 = "Makoto Furukawa, Wataru Hatano, Aya Hirano"
        for (actor in strActors4.split(",")) {
            actors4.add(actor)
        }
        val actors5 = ArrayList<String>()
        val strActors5 = "Seth MacFarlane, Alex Borstein, Seth Green"
        for (actor in strActors5.split(",")) {
            actors5.add(actor)
        }
        val actors6 = ArrayList<String>()
        val strActors6 = "John Wesley Shipp, Amanda Pays, Alex Désert"
        for (actor in strActors6.split(",")) {
            actors6.add(actor)
        }
        val actors7 = ArrayList<String>()
        val strActors7 = "Ben McKenzie, Donal Logue, David Mazouz"
        for (actor in strActors7.split(",")) {
            actors7.add(actor)
        }
        val actors8 = ArrayList<String>()
        val strActors8 = "Sarkis Ninos, Rushi Kota, Jaicy Elliot"
        for (actor in strActors8.split(",")) {
            actors8.add(actor)
        }
        val actors9 = ArrayList<String>()
        val strActors9 = "Esme Creed-Miles, Mireille Enos, Dermot Mulroney"
        for (actor in strActors9.split(",")) {
            actors9.add(actor)
        }
        val actors10 = ArrayList<String>()
        val strActors10 = "Finn Jones, Jessica Henwick, Jessica Stroup"
        for (actor in strActors10.split(",")) {
            actors10.add(actor)
        }

        tvShows.add(
            TvShowsEntity(
                "tv1",
                "The Arrow",
                strActors1,
                "Panah adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow",
                "2012",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
            )
        )
        tvShows.add(
            TvShowsEntity(
                "tv2",
                "Doom Patrol",
                strActors2,
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "2019",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/kOAn06LmRCg4YiSStwrGL6UOQ3a.jpg",
            )
        )
        tvShows.add(
            TvShowsEntity(
                "tv3",
                "Dragon Ball Z",
                strActors3,
                "After learning that he is from another planet, a warrior named Goku and his friends are prompted to defend it from an onslaught of extraterrestrial enemies.",
                "1989",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6VKOfL6ihwTiB5Vibq6QTfzhxA6.jpg",
            )
        )
        tvShows.add(
            TvShowsEntity(
                "tv4",
                "Fairy Tail: Dragon Cry",
                strActors4,
                "Natsu Dragneel and his friends travel to the island Kingdom of Stella, where they will reveal dark secrets, fight the new enemies and once again save the world from destruction.",
                "2017",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4CtvjdvuRj3iPlvtpvFomhTxjXR.jpg",
            )
        )
        tvShows.add(
            TvShowsEntity(
                "tv5",
                "Family Guy",
                strActors5,
                "Seri animasi animasi Freakin 'Sweet yang sakit, terpelintir, dan salah, menampilkan petualangan keluarga Griffin yang disfungsional. Peter yang kikuk dan Lois yang sudah lama menderita memiliki tiga anak. Stewie (bayi yang brilian tetapi sadis yang bertekad membunuh ibunya dan mengambil alih dunia), Meg (yang tertua, dan merupakan gadis yang paling tidak populer di kota) dan Chris (anak tengah, dia tidak terlalu cerdas tetapi memiliki hasrat untuk film ). Anggota terakhir keluarga itu adalah Brian - anjing yang bisa bicara dan lebih dari sekadar hewan peliharaan, ia menjaga Stewie, sementara menghirup Martinis dan memilah-milah masalah hidupnya sendiri.",
                "1999",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9RBeCo8QSaoJLmmuzlwzVH3Hi12.jpg",
            )
        )
        tvShows.add(
            TvShowsEntity(
                "tv6",
                "The Flash",
                strActors6,
                "When a bolt of lightening crashes through a police crime lab, a mix of electrically charged substances bathes chemist Barry Allen, transforming him into the fastest man alive--The Flash.",
                "1990",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fi1GEdCbyWRDHpyJcB25YYK7fh4.jpg",
            )
        )
        tvShows.add(
            TvShowsEntity(
                "tv7",
                "Gotham",
                strActors7,
                "Semua orang tahu nama Komisaris Gordon. Dia adalah salah satu musuh terbesar dunia kejahatan, seorang pria yang reputasinya identik dengan hukum dan ketertiban. Tapi apa yang diketahui tentang kisah Gordon dan kenaikannya dari detektif pemula ke Komisaris Polisi? Apa yang diperlukan untuk menavigasi berbagai lapisan korupsi yang diam-diam memerintah Kota Gotham, tempat bertelurnya penjahat paling ikonik di dunia? Dan keadaan apa yang menciptakan mereka - persona yang lebih besar dari kehidupan yang akan menjadi Catwoman, The Penguin, The Riddler, Two-Face dan The Joker?",
                "2014",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
            )
        )
        tvShows.add(
            TvShowsEntity(
                "tv8",
                "Grey's Anatomy: B-Team",
                strActors8,
                "New interns' tackle their first day as surgeons at Grey Sloan Memorial under the watchful and stern eye of Chief Bailey.",
                "2018",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/s0FZu5JBH1OdH5kIVfck3c2DpkC.jpg",
            )
        )
        tvShows.add(
            TvShowsEntity(
                "tv9",
                "Hanna",
                strActors9,
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "2019",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pe10EUjgO2jgwiu01MAv9l3IjxG.jpg",
            )
        )
        tvShows.add(
            TvShowsEntity(
                "tv10",
                "Marvel's Iron Fist",
                strActors10,
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "2017",
                false,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4l6KD9HhtD6nCDEfg10Lp6C6zah.jpg",
            )
        )
        return tvShows
    }

    fun generateActor(): String {
        return "Bradley Cooper, Lady Gaga, Sam Elliott"
    }

    fun generateDummyMovieDetail(): DetailMovieEntity {
        return DetailMovieEntity(generateDetailMovies()[0])
    }

    fun generateDummyTvShowDetail(): DetailTvShowsEntity {
        return DetailTvShowsEntity(generateDetailTvShows()[0])
    }
}