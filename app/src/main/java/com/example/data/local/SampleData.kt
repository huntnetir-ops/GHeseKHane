package com.example.data.local

import com.example.data.model.Achievement
import com.example.data.model.MiniGame
import com.example.data.model.Story
import com.example.data.model.StoryCategory
import com.example.data.model.StoryChoice
import com.example.data.model.StoryPage
import com.example.data.model.WorldFact

object SampleData {

    val categories = listOf(
        StoryCategory("cat_all", "همه داستانها", "book", "#6C5CE7"),
        StoryCategory("cat_animals", "حیوانات", "fox", "#FF7675"),
        StoryCategory("cat_space", "فضا و ماجراجویی", "rocket", "#0984E3"),
        StoryCategory("cat_fantasy", "فانتزی", "magic", "#A29BFE"),
        StoryCategory("cat_family", "خانواده و دوستی", "heart", "#FD79A8"),
        StoryCategory("cat_school", "مدرسه و مهارتهای زندگی", "school", "#00CEC9"),
        StoryCategory("cat_nature", "طبیعت و محیط زیست", "leaf", "#00B894"),
        StoryCategory("cat_science", "علم و فناوری", "robot", "#E17055"),
        StoryCategory("cat_bedtime", "قصههای قبل از خواب", "moon", "#2D3436")
    )

    val defaultAchievements = listOf(
        Achievement("ach_first_story", "اولین قصه!", "تبریک! اولین داستان خود را تمام کردی.", "star", 1),
        Achievement("ach_bookworm", "کتابخوان کوچک", "خواندن ۵ داستان جذاب.", "book", 5),
        Achievement("ach_animal_friend", "دوست حیوانات", "خواندن ۳ داستان درباره حیوانات.", "fox", 3),
        Achievement("ach_space_explorer", "ماجراجوی بزرگ", "سفر به فضا و جهانهای عجیب.", "rocket", 2),
        Achievement("ach_bedtime_master", "خوابهای شیرین", "گوش دادن به ۳ قصه شب آرامش‌بخش.", "moon", 3),
        Achievement("ach_life_skills", "ذهن خلاق", "یادگیری مهارتهای حل مسئله و دوستی.", "brain", 4),
        Achievement("ach_nature_guardian", "نگهبان طبیعت", "مراقبت از گلها، درختان و زمین.", "leaf", 3)
    )

    val worldFacts = listOf(
        WorldFact(
            id = "wf_1",
            category = "حیوانات",
            title = "چرا زنبورها برای زمین خیلی مهم هستند؟",
            content = "زنبورهای عسل با گرده‌افشانی به رشد میوه‌ها، سبزیجات و گل‌ها کمک می‌کنند. بیش از یک سوم غذایی که ما می‌خوریم به خاطر تلاش زنبورها تولید می‌شود!",
            funFact = "یک زنبور عسل در طول زندگی خود فقط حدود یک دوازدهم قاشق چای‌خوری عسل می‌سازد!",
            icon = "bee"
        ),
        WorldFact(
            id = "wf_2",
            category = "فضا",
            title = "سیاره سرخ یا مریخ چیست؟",
            content = "مریخ چهارمین سیاره منظومه شمسی است. رنگ سرخ آن به خاطر آهن موجود در خاکش است. دانشمندان ربات‌های کاوشگر زیادی به مریخ فرستاده‌اند.",
            funFact = "در مریخ بزرگ‌ترین کوه آتشفشانی منظومه شمسی به نام المپوس قرار دارد!",
            icon = "rocket"
        ),
        WorldFact(
            id = "wf_3",
            category = "فرهنگها",
            title = "جشن نوروز و بهار طبیعت",
            content = "نوروز یکی از قدیمی‌ترین جشن‌های جهان است که با آمدن فصل بهار و نو شدن طبیعت آغاز می‌شود. سفره هفت‌سین نماد سلامتی، برکت و شادی است.",
            funFact = "سبزه روی سفره هفت‌سین نماد زندگی دوباره و سرسبزی طبیعت است!",
            icon = "flower"
        ),
        WorldFact(
            id = "wf_4",
            category = "اختراعات",
            title = "چگونه چرخ دنیای انسان‌ها را تغییر داد؟",
            content = "اختراع چرخ در هزاران سال پیش یکی از بزرگ‌ترین کشفیات تاریخ بشر بود. قبل از آن جابه‌جایی وسایل سنگین بسیار سخت بود.",
            funFact = "اولین چرخ‌های ساخته شده از سنگ و چوب سنگین بودند و بعداً سبک‌تر شدند!",
            icon = "wheel"
        ),
        WorldFact(
            id = "wf_5",
            category = "مشاغل",
            title = "آتشنشان‌ها چگونه کار می‌کنند؟",
            content = "آتش‌نشان‌ها قهرمانانی هستند که نه تنها آتش را خاموش می‌کنند، بلکه در مواقع سیل، زلزله و حتی نجات حیوانات گیر افتاده کمک می‌کنند.",
            funFact = "لباس‌های آتش‌نشانی از پارچه‌های مخصوص ضد حرارت و نسوز ساخته می‌شوند!",
            icon = "fire"
        )
    )

    val miniGames = listOf(
        MiniGame(
            id = "mg_memory",
            title = "بازی کارت‌های حافظه داستانی",
            type = "MEMORY",
            description = "کارت‌های جفت و مشابه شخصیت‌های قصه را پیدا کن!",
            icon = "puzzle"
        ),
        MiniGame(
            id = "mg_quiz",
            title = "مسابقه هوش و قصه",
            type = "QUIZ",
            description = "به سوالات جالب درباره قصه پاسخ بده و مدال بگیر!",
            icon = "star"
        ),
        MiniGame(
            id = "mg_match",
            title = "جورچین دوستان طبیعت",
            type = "MATCH",
            description = "حیوانات را به خانه و غذای مناسبشان وصل کن!",
            icon = "leaf"
        )
    )

    val stories = listOf(
        // Story 1
        Story(
            id = "story_1",
            title = "روباه و بادبادک قرمز",
            description = "روباه کوچولویی به نام نارنجی بادبادک زیبایی پیدا می‌کند و یاد می‌گیرد چطور با دوستانش شریک شود.",
            ageGroup = "3-5",
            categoryId = "cat_animals",
            categoryName = "حیوانات",
            coverDrawable = "img_hero",
            estimatedReadingTime = 3,
            hasAudio = true,
            moralLesson = "تقسیم کردن اسباب‌بازی‌ها با دوستان، شادی را چند برابر می‌کند.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "در یک جنگل سرسبز و قشنگ، روباه کوچولویی به نام «نارنجی» زندگی می‌کرد. نارنجی عاشق بازی در میان برگ‌های پاییزی بود."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "یک روز صبح، وقتی نارنجی داشت تاب می‌خورد، چشمش به یک بادبادک قرمز قشنگ افتاد که لای شاخه‌های درخت گیر کرده بود!"
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "نارنجی با احتیاط بادبادک را پایین کشید. سنجاب کوچولو از دور بادبادک را دید و با خوشحالی دوید تا بپرسد آیا می‌تواند با هم بادبادک‌بازی کنند؟",
                    choices = listOf(
                        StoryChoice("نارنجی با سنجاب شریک شود و با هم بازی کنند", 4, "کار عالی! بازی دستجمعی خیلی لذت‌بخش است."),
                        StoryChoice("نارنجی بادبادک را برای خودش نگه دارد", 5, "تنها بازی کردن کمی دلگیر است...")
                    )
                ),
                StoryPage(
                    pageNumber = 4,
                    text = "نارنجی خندید و گفت: «البته! نخ بادبادک را تو بگیر و من نخ را رها می‌کنم!» بادبادک تا اوج آسمان بالا رفت و خنده‌های آن دو در جنگل پیچید."
                ),
                StoryPage(
                    pageNumber = 5,
                    text = "نارنجی کمی تنها بازی کرد، اما دید بدون دوستش بازی کیف نمی‌دهد. پس سنجاب را صدا زد و هر دو تا غروب آفتاب با هم بادبادک‌بازی کردند."
                )
            )
        ),

        // Story 2
        Story(
            id = "story_2",
            title = "سفر کوچک به ماه",
            description = "سامان کوچولو با سفینه خیالی‌اش به ماه سفر می‌کند تا با موش فضانورد ملاقات کند.",
            ageGroup = "6-8",
            categoryId = "cat_space",
            categoryName = "فضا و ماجراجویی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "قدرت تخیل و کنجکاوی، انسان را به بزرگ‌ترین کشفیات می‌رساند.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "سامان تلسکوپ کوچک کودکی‌اش را رو به پنجره اتاق تنظیم کرده بود. ماه امشب مثل یک کلوچه برشته درخشان بود."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "سامان کلاه ایمنی اسباب‌بازی‌اش را بر سر گذاشت، روی صندلی چرخدار نشست و گفت: ۳... ۲... ۱... پرتاب!"
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "در عالم خواب و خیال، سفینه سامان از میان ابرها گذشت و روی خاک نرم و نقره‌ای ماه فرود آمد. آنجا یک موش کوچولوی فضانورد با لباس سفید منتظرش بود!"
                ),
                StoryPage(
                    pageNumber = 4,
                    text = "موش فضانورد به سامان یک سنگ درخشان هدیه داد و گفت: «هر وقت به آسمان نگاه کنی، یاد بدار که دانسته و دانش تو انتهایی ندارد!»"
                )
            )
        ),

        // Story 3
        Story(
            id = "story_3",
            title = "دوست جدید مدرسه",
            description = "مریم در روز اول مدرسه با دختری باهوش اما خجالتی آشنا می‌شود و به او کمک می‌کند تا دوست پیدا کند.",
            ageGroup = "6-8",
            categoryId = "cat_school",
            categoryName = "مدرسه و مهارتهای زندگی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "پذیرش دیگران و مهربانی در اولین برخورد، دوستی‌های پایدار می‌سازد.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "زنگ فسحت زده شد. همه بچه‌ها به حیاط مدرسه رفتند تا خاله بازی و زنگ ورزش داشته باشند."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "مریم دید که سارا گوشه حیاط تنها ایستاده و نقاشی می‌کشد. سارا تازه به این شهر آمده بود و هنوز هیچ دوستی نداشت."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "مریم نزد سارا رفت و گفت: «مداد رنگی‌هایت چقدر قشنگند! می‌خواهی با هم نقاشی بکشیم؟» لبخند قشنگی روی صورت سارا نشست."
                ),
                StoryPage(
                    pageNumber = 4,
                    text = "از آن روز به بعد، سارا و مریم بهترین دوستان یکدیگر شدند و در درس‌ها همیشه به هم کمک می‌کردند."
                )
            )
        ),

        // Story 4
        Story(
            id = "story_4",
            title = "درختی که تشنه بود",
            description = "داستان آرمین که یاد می‌گیرد چطور با آبیاری درخت کوچک حیاط، گل‌ها و پرندگان را شاد کند.",
            ageGroup = "3-5",
            categoryId = "cat_nature",
            categoryName = "طبیعت و محیط زیست",
            coverDrawable = "img_hero",
            estimatedReadingTime = 3,
            hasAudio = true,
            moralLesson = "مراقبت از گیاهان و درختان وظیفه مهربانانه همه ماست.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "در حیاط خانه آرمین، نهال کوچکی با برگ‌های سبز کمرنگ وجود داشت که آفتاب تابستان بر آن می‌تابید."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "آرمین دید برگ‌های درخت کوچولو کمی پژمرده شده‌اند. او سطل آب کوچکش را پر کرد و با گام‌های آهسته سمت نهال رفت."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "وقتی آرمین ریشه‌های درخت را سیراب کرد، خنکی آب برگ‌های درخت را تازه کرد و پروانه‌ای زرد روی شاخه‌اش نشست!"
                )
            )
        ),

        // Story 5
        Story(
            id = "story_5",
            title = "قطار کوچک شهر",
            description = "قطار قرمز شهر همواره ایستگاه به ایستگاه مردم را به مقصد می‌رساند و ارزش نظم و وقت‌شناسی را آموزش می‌دهد.",
            ageGroup = "3-5",
            categoryId = "cat_science",
            categoryName = "علم و فناوری",
            coverDrawable = "img_hero",
            estimatedReadingTime = 3,
            hasAudio = true,
            moralLesson = "نظم، احترام به زمان و همکاری باعث می‌شود کارها منظم انجام شود.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "«چو چو! سوت سوت!» قطار کوچولوی قرمز همیشه راس ساعت ۸ صبح در ایستگاه مرکزی حاضر بود."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "آقای سوزن‌بان چراغ سبز را روشن کرد. بچه‌ها، معلمان و نانواها سوار قطار شدند تا به مقصد بروند."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "قطار کوچک با لبخند ریل‌ها را طی می‌کرد زیرا می‌دانست کمک به مسافران چقدر کار مهم و ارزشمندی است."
                )
            )
        ),

        // Story 6
        Story(
            id = "story_6",
            title = "راز جنگل آبی",
            description = "پری کوچولو و خرگوش دانشمند، راز چشمه جادویی جنگل آبی را با حل معماهای هوشمندانه کشف می‌کنند.",
            ageGroup = "9-12",
            categoryId = "cat_fantasy",
            categoryName = "فانتزی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 5,
            hasAudio = true,
            moralLesson = "تفکر منطقی، همکاری گروهی و صبر، گره از پیچیده‌ترین معماها می‌گشاید.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "در اقیانوس سبز شمال، جنگلی قرار داشت که شب‌ها درختانش نور آبی ملایمی ساطع می‌کردند."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "خرگوش دانشمند عینکش را جابه‌جا کرد و گفت: «چشمه آبی خشک شده زیرا سنگ‌های توازن به بهم خورده‌اند.»"
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "آن‌ها باید بر اساس الگوی رنگ‌ها، سه سنگ جادویی را در جای مناسب قرار می‌دادند.",
                    choices = listOf(
                        StoryChoice("سنگ آبی را در مرکز قرار دهند", 4, "انتخاب هوشمندانه با توجه به تقارن!"),
                        StoryChoice("سنگ قرمز را در مرکز قرار دهند", 5, "امتحان مجدد...")
                    )
                ),
                StoryPage(
                    pageNumber = 4,
                    text = "با قرار گرفتن سنگ آبی در مرکز، آب زلال چشمه فواره زد و همه حیوانات جنگل به جشن و شادی پرداختند."
                ),
                StoryPage(
                    pageNumber = 5,
                    text = "آن‌ها دوباره معما را بررسی کردند و با تغییر ترتیب سنگ‌ها به نتیجه درست رسیدند."
                )
            )
        ),

        // Story 7
        Story(
            id = "story_7",
            title = "رباتی که دوست پیدا کرد",
            description = "ربات هوشمند آریا در محیط کارگاه، احساسات انسانی، مهربانی و کمک کردن را تجربه می‌کند.",
            ageGroup = "6-8",
            categoryId = "cat_science",
            categoryName = "علم و فناوری",
            coverDrawable = "img_hero",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "تکنولوژی هنگامی ارزشمند است که در خدمت دوستی و محبت باشد.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "«بیپ بپ!» ربات روبو دارای بدن فلزی درخشان و دو چشم لامپی آبی بود."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "یک روز روبو دید که پرنده کوچکی از حیاط وارد کارگاه شده و خسته است. روبو به آرامی ظرف کوچکی از آب برای پرنده آورد."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "پرنده کوچک روی شانه ربات نشست و نغمه زیبایی خواند. روبو متوجه شد که قلب الکترونیکی‌اش گرم شده است!"
                )
            )
        ),

        // Story 8
        Story(
            id = "story_8",
            title = "روزی که باران نیامد",
            description = "داستان همدلی و صرفه‌جویی در مصرف آب توسط اهالی دهکده برای عبور از روزهای گرم تابستان.",
            ageGroup = "6-8",
            categoryId = "cat_nature",
            categoryName = "طبیعت و محیط زیست",
            coverDrawable = "img_hero",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "صرفه‌جویی در منابع حیاتی مثل آب، نشانه دانایی و مسئولیت‌پذیری است.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "تابستان گرمی بود و ابرها چند هفته‌ای بود که در آسمان دهکده آفتابی دیده نمی‌شدند."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "کودکان دهکده تصمیم گرفتند شیرهای آب را محکم ببندند و هنگام شستشوی دست‌ها آب را هدر ندهند."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "چند روز بعد، با صرفه‌جویی همگانی، چشمه دهکده پرآب ماند و بالاخره لکه‌های ابر باران‌زا در آسمان ظاهر شدند."
                )
            )
        ),

        // Story 9
        Story(
            id = "story_9",
            title = "سفر به اعماق دریا",
            description = "دلفین دانا دنیای شگفت‌انگیز زیر آب و مرجان‌های رنگارنگ را به ماهی کوچولو نشان می‌دهد.",
            ageGroup = "6-8",
            categoryId = "cat_science",
            categoryName = "علم و فناوری",
            coverDrawable = "img_hero",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "اقیانوس‌ها خانه هزاران موجود زنده هستند؛ نریختن زباله در دریا واجب است.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "زیر سطح آبی دریا، دنیایی پر از صدف‌ها، صخره‌های مرجانی و ماهی‌های نورانی برپا بود."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "دلفین دانا به ماهی کوچولو گفت: «ببین! این صخره‌های مرجانی مثل جنگل‌های روی زمین برای ما اکسیژن تولید می‌کنند.»"
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "آن‌ها همراه هم زباله پلاستیکی کوچکی که از بالادست آمده بود را جمع کردند تا دریا همیشه پاکیزه بماند."
                )
            )
        ),

        // Story 10
        Story(
            id = "story_10",
            title = "کفشهای جادویی",
            description = "پسرکی که فکر می‌کرد موفقیتش به خاطر کفش‌های جدیدش است، اما متوجه تمرین و اراده خودش می‌شود.",
            ageGroup = "9-12",
            categoryId = "cat_school",
            categoryName = "مدرسه و مهارتهای زندگی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 5,
            hasAudio = true,
            moralLesson = "کلید واقعی موفقیت، تمرین، باور به توانایی خود و تلاش مداوم است.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "پویا همیشه دلش می‌خواست در دویدن سریع‌ترین باشد. پدرش برای تولدش یک جفت کفش ورزشی قرمز خرید."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "پویا در مسابقه اول شد و فکر کرد کفش‌ها جادویی هستند. اما روز بعدی فراموش کرد کفش‌های قرمز را بپوشد!"
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "او با کفش‌های معمولی‌اش هم دوباره تلاش کرد و توانست سریع بدود! مربی لبخند زد و گفت: «جادو در پاهای پرتوان و تمرین خود توست!»"
                )
            )
        ),

        // Story 11
        Story(
            id = "story_11",
            title = "دخترک و ستاره گمشده",
            description = "داستان مهربانی هلیا که به ستاره کوچولویی که از آسمان افتاده کمک می‌کند به آغوش مادرش ماه برگردد.",
            ageGroup = "3-5",
            categoryId = "cat_fantasy",
            categoryName = "فانتزی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 3,
            hasAudio = true,
            moralLesson = "کمک به کسانی که در سختی هستند، نور دوستی را در دل‌ها روشن می‌سازد.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "شب درخشان و آرامی بود. هلیا کنار پنجره نشسته بود که چشمش به یک نقطه درخشان روی سبزه حیاط افتاد."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "یک ستاره کوچولوی نقره‌ای از آسمان سرخ خورده بود! ستاره کمی آروم می‌گریست و دلش برای ماه تنگ شده بود."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "هلیا با نردبان اسباب‌بازی و بالن کاغذی به ستاره کمک کرد تا دوباره پرواز کند و در جایگاهش بدرخشد."
                )
            )
        ),

        // Story 12
        Story(
            id = "story_12",
            title = "پیرمرد و باغچه کوچک",
            description = "بابابزرگ و نوه‌اش سبزیجات تازه می‌کارند و برکت زحمتکشی را جشن می‌گیرند.",
            ageGroup = "6-8",
            categoryId = "cat_family",
            categoryName = "خانواده و دوستی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "صبر و همیاری با بزرگترها تجربه و برکت فراوانی به همراه دارد.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "بابابزرگ همیشه کلاه حصیری‌اش را بر سر می‌گذاشت و بیلچه باغبانی را به علی کوچولو می‌داد."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "آن‌ها دانه‌های گوجه‌فرنگی و ریحان را کاشتند، خاک را نرم کردند و هر روز به آن آب دادند."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "بعد از چند هفته، گوجه‌های قرمز و خوشمزه سر از خاک برآوردند و همه اعضای خانواده دور سفره افطار جشن گرفتند."
                )
            )
        ),

        // Story 13
        Story(
            id = "story_13",
            title = "ماجرای یک زنبور کوچک",
            description = "زنبور کوچولویی به نام «عسلی» یاد می‌گیرد که کار گروهی در کندو چقدر نتیجه شیرینی دارد.",
            ageGroup = "3-5",
            categoryId = "cat_animals",
            categoryName = "حیوانات",
            coverDrawable = "img_hero",
            estimatedReadingTime = 3,
            hasAudio = true,
            moralLesson = "کار گروهی و همفکری باعث می‌شود بزرگ‌ترین کارها آسان شوند.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "عسلی هنوز زنبور خیلی کوچکی بود و پرواز کردن بین گل‌های بابونه برایش تازه بود."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "وقتی یک گل بزرگ پیدا کرد، به‌تنهایی نمی‌توانست شهد آن را به کندو ببرد. پس دوستانش را صدا زد."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "با کمک تمام زنبورها، کندو پر از عسل معطر شد و عسلی فهمید قدرت گروه چقدر زیاد است!"
                )
            )
        ),

        // Story 14
        Story(
            id = "story_14",
            title = "اولین روز مدرسه",
            description = "نیما کمی استرس داشت، اما با بازی‌های گروهی معلم، احساس آرامش و شادی پیدا کرد.",
            ageGroup = "6-8",
            categoryId = "cat_school",
            categoryName = "مدرسه و مهارتهای زندگی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "احساس ترس از تجربه جدید طبیعی است؛ با قدم اول و لبخند همه‌چیز شیرین می‌شود.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "صبح روز اول مهر، نیما کیف نویش را بر دوش انداخت. قلبش تند می‌زد و کمی خجالت می‌کشید."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "معلم با لبخند مهربانش همه بچه‌ها را دور هم جمع کرد و مسابقه اسم‌بازی راه انداخت."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "نیما متوجه شد همه بچه‌ها مثل او هستند. تا زنگ آخر، او سه دوست جدید پیدا کرده بود!"
                )
            )
        ),

        // Story 15
        Story(
            id = "story_15",
            title = "شهر بدون زباله",
            description = "کودکان محله با جداسازی زباله‌های خشک و تر، شهرشان را به تمیزترین شهر تبدیل می‌کنند.",
            ageGroup = "9-12",
            categoryId = "cat_nature",
            categoryName = "طبیعت و محیط زیست",
            coverDrawable = "img_hero",
            estimatedReadingTime = 5,
            hasAudio = true,
            moralLesson = "تفکیک زباله و بازیافت، زمین را برای آیندگان پاک نگه‌می‌دارد.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "پارک محله پر از کاغذ و قوطی‌های خالی شده بود. بچه‌ها تصمیم گرفتند سطل‌های رنگی بازیافت بسازند."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "سطل آبی برای کاغذ، سطل زرد برای پلاستیک و سطل سبز برای زباله تر مشخص شد."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "شهردار شهر مدال «شهروند افتخاری» را به بچه‌ها اهدا کرد و پارک دوباره سرسبز و پاکیزه شد."
                )
            )
        ),

        // Story 16
        Story(
            id = "story_16",
            title = "مسابقه بزرگ حل مسئله",
            description = "چهار دوست با مهارت‌های متفاوت در مسابقه فکری شرکت کرده و با ترکیب استعدادهایشان برنده می‌شوند.",
            ageGroup = "9-12",
            categoryId = "cat_school",
            categoryName = "مدرسه و مهارتهای زندگی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 5,
            hasAudio = true,
            moralLesson = "هر فرد استعداد متفاوتی دارد؛ ترکیب مهارتهای مختلف باعث موفقیت می‌شود.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "مسابقه ریاضی و هوش مدرسه شروع شده بود. سوالات شامل معماهای هندسی، کلمات و برج‌سازی بود."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "رضا در محاسبات سریع بود، مینا در نقاشی و ساخت‌وساز عالی بود و کیان معماهای متنی را خوب حل می‌کرد."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "آن‌ها با تقسیم وظایف درست، برج را با استحکام ساختند و مدال طلای مسابقه را کسب کردند."
                )
            )
        ),

        // Story 17
        Story(
            id = "story_17",
            title = "سفر به یک کشور دور",
            description = "سارا از طریق نامه‌نگاری با دوستی در کشور ژاپن، با فرهنگ، غذاها و سنت‌های جالب آن‌ها آشنا می‌شود.",
            ageGroup = "9-12",
            categoryId = "cat_family",
            categoryName = "خانواده و دوستی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 5,
            hasAudio = true,
            moralLesson = "احترام به تفاوت‌های فرهنگی و جغرافیایی، جهان را زیباتر می‌سازد.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "سارا یک نامه حاوی یک نقاشی زیبا از شکوفه‌های گیلاس (ساکورا) از توکیو دریافت کرد."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "دوست ژاپنی‌اش درباره هنر اوریگامی (کاغذ و تا) و نحوه ساخت درنای کاغذی برایش نوشته بود."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "سارا هم در پاسخ، عکس‌هایی از تخت جمشید، فرش‌های ایرانی و پسته برای دوستش فرستاد تا دوستی فراملی‌شان محکم‌تر شود."
                )
            )
        ),

        // Story 18
        Story(
            id = "story_18",
            title = "قهرمان کوچک محله",
            description = "سپهر با رعایت نکات ایمنی عبور از خیابان و بستن کمربند ایمنی، الگوی بچه‌های محله می‌شود.",
            ageGroup = "6-8",
            categoryId = "cat_school",
            categoryName = "مدرسه و مهارتهای زندگی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "توجه به قوانین راهنمایی و ایمنی، سلامت ما و عزیزانمان را تضمین می‌کند.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "سپهر همیشه وقتی سوار ماشین می‌شد، اول کمربند ایمنی‌اش را محکم می‌بست."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "در خط‌کشی عابر پیاده، او صبر می‌کرد تا چراغ راهنمایی برای پیاده‌ها سبز شود."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "پلیس راهنمایی محله به سپهر نشان «همیار پلیس نمونه» را اهدا کرد!"
                )
            )
        ),

        // Story 19
        Story(
            id = "story_19",
            title = "کتابی که حرف میزد",
            description = "داستان جادویی کتاب کهنه‌ای در کتابخانه که قصه شاهنامه و رستم را برای بچه‌ها روایت می‌کند.",
            ageGroup = "9-12",
            categoryId = "cat_fantasy",
            categoryName = "فانتزی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 5,
            hasAudio = true,
            moralLesson = "کتاب‌ها گنجینه‌های زنده تاریخ و فرهنگ ما هستند.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "سینا در انتهای کتابخانه مدرسه کتابی با جلد مخمل آبی پیدا کرد که غبار نرمی روی آن نشست."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "وقتی کتاب را باز کرد، صدایی گرم و مهربان گفت: «سلام سینا! آیا مایلی قصه رخش و هفت‌خوان را برایت بگویم؟»"
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "تصاویر کتاب زنده شدند و سینا خود را در قلب حماسه‌های کهن ایرانی یافت."
                )
            )
        ),

        // Story 20 (Bedtime Sleep Story)
        Story(
            id = "story_20",
            title = "آخرین ابر آسمان",
            description = "قصه قبل از خواب بسیار آرامش‌بخش درباره ابری نرم که روی بال‌های ماه تاب می‌خورد تا کودکان بخوابند.",
            ageGroup = "3-5",
            categoryId = "cat_bedtime",
            categoryName = "قصههای قبل از خواب",
            coverDrawable = "img_night",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "آرامش شب، فرصتی برای استراحت بدن، رویابافی و تجدید انرژی است.",
            isBedtimeStory = true,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "شب فرا رسیده بود و تمام ستارگان کوچک یکی‌یکی چراغ‌هایشان را کم‌نور می‌کردند."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "ابری نرم و سفید مثل پنبه، روی شانه ماه طلایی آرام گرفته بود و نسیم خنکی آن را تاب می‌داد."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "جنگل خاموش شده بود و تمام حیوانات کوچولو چشمانشان را بستند... شبت بخیر کوچولو، رویای شیرین ببینی."
                )
            )
        ),

        // Story 21 (Fantasy / Bedtime)
        Story(
            id = "story_21",
            title = "افسانه خورشید و ماه",
            description = "داستان جادویی چگونگی نوبت‌بندی خورشید و ماه برای تابیدن بر زمین و ایجاد روز و شب.",
            ageGroup = "6-8",
            categoryId = "cat_bedtime",
            categoryName = "قصههای قبل از خواب",
            coverDrawable = "img_night",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "نظم آفرینش و نوبت‌بندی زیبا، به جهان زیبایی و تعادل می‌بخشد.",
            isBedtimeStory = true,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "در زمان‌های بسیار دور، خورشید درخشان و ماه نقره‌ای در پهنه آسمان با هم گفتگو می‌کردند."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "خورشید گفت: «من به گیاهان گرمایی می‌بخشم تا رشد کنند.» ماه گفت: «و من با نور ملایمم، زمینه استراحت و خواب آرام زمین را فراهم می‌کنم.»"
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "آن‌ها تصمیم گرفتند با لبخند و برادری، نوبت را رعایت کنند: خورشید روزها بتابد و ماه شب‌ها نگهبان خواب کودکان باشد."
                )
            )
        ),

        // Story 22 (Science & Mystery)
        Story(
            id = "story_22",
            title = "کارآگاه روبو و معماهای شهر",
            description = "ربات کارآگاه با بررسی نشانه‌ها و استدلال منطقی، ساعت گمشده برج شهر را پیدا می‌کند.",
            ageGroup = "9-12",
            categoryId = "cat_science",
            categoryName = "علم و فناوری",
            coverDrawable = "img_hero",
            estimatedReadingTime = 5,
            hasAudio = true,
            moralLesson = "دقت به جزئیات، تفکر منطقی و عدم قضاوت عجولانه حل‌کننده معماهاست.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "چرخدنده اصلی برج ساعت شهر ناپدید شده بود و ساعت بزرگ از حرکت ایستاد!"
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "کارآگاه روبو با ذره‌بین دیجیتالش سه ردپا پیدا کرد: برگه درخت، رد پای رد گربه و قطره‌ای روغن."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "روبو متوجه شد کلاغ کوچولو چرخدنده درخشان را برای تزیین لانه برده بود! او با مهربانی چرخدنده را پس گرفت و ساعت دوباره به کار افتاد."
                )
            )
        ),

        // Story 23 (Persian Mythology)
        Story(
            id = "story_23",
            title = "سیمرغ و پر جادویی",
            description = "داستان حماسی سیمرغ بر فراز کوه قاف که به پسرک چوپان شجاعت و دانایی می‌بخشد.",
            ageGroup = "9-12",
            categoryId = "cat_fantasy",
            categoryName = "فانتزی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 5,
            hasAudio = true,
            moralLesson = "خرد، راستی و شجاعت بزرگ‌ترین زره انسان در برابر مشکلات است.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "بر بلندای کوه افسانه‌ای قاف، پرنده‌ای دانا به نام سیمرغ با پرهای طلایی و فیروزه‌ای زندگی می‌کرد."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "پسرک چوپان برای رهایی دهکده‌اش از خشکسالی راه دراز کوهستان را پیمود تا از دانایی سیمرغ بهره‌مند شود."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "سیمرغ پر درخشانی به او داد و گفت: «هرگاه با راستی و شجاعت از این پر نگهداری کنی، چشمه امید جاری خواهد شد.»"
                )
            )
        ),

        // Story 24 (Nature & Animals)
        Story(
            id = "story_24",
            title = "خانه درختی پرندگان",
            description = "امیر و نیکی با چوب‌های بازیافتی و رنگ‌های طبیعی، برای پرندگان زمستانی آشیانه‌ای گرم می‌سازند.",
            ageGroup = "6-8",
            categoryId = "cat_nature",
            categoryName = "طبیعت و محیط زیست",
            coverDrawable = "img_hero",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "مهربانی با حیوانات و ساخت آشیانه در فصل سرما دل‌ها را گرم می‌کند.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "زمستان از راه رسیده بود و باد سردی در میان شاخه‌های لخت درختان کاج می‌پیچید."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "امیر و نیکی با تکه‌چوب‌های کارگاه بابابزرگ، دو آشیانه کوچولو ساختند و داخلش دانه‌های گندم ریختند."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "گنجشک‌ها و فنچ‌های کوچک با شادی به خانه درختی آمدند و با نغمه‌هایشان پاداش مهربانی بچه‌ها را دادند."
                )
            )
        ),

        // Story 25 (Music & Arts)
        Story(
            id = "story_25",
            title = "شهر نت‌های خنده‌رو",
            description = "دخترکی با ساز بلز خود به شهر نت‌ها سفر کرده و نوایی شاد برای مردم خسته می‌نوازد.",
            ageGroup = "3-5",
            categoryId = "cat_family",
            categoryName = "خانواده و دوستی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 3,
            hasAudio = true,
            moralLesson = "موسیقی و هنر، خستگی را از بین برده و دل‌ها را لبریز از شادی می‌سازد.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "در سرزمین آهنگ‌ها، نت‌های «دو، ر، می، فا، سول» با کفش‌های رنگارنگشان روی خطوط حامل بالا و پایین می‌پریدند."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "مهتا کوچولو مضرابش را روی تیغه‌های بلز زد: «دینگ! دانگ! زنگ!» آهنگ شادی در فضای شهر پیچید."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "مردم شهر دست زدند و همراه با نت‌های خنده‌رو شروع به خواندن سرود دوستی کردند."
                )
            )
        ),

        // Story 26 (Life Skills)
        Story(
            id = "story_26",
            title = "روزی که ساعت ایستاد",
            description = "وقتی زمان در دهکده متوقف شد، کودکان متوجه اهمیت برنامه‌ریزی، زمان و نظم شدند.",
            ageGroup = "6-8",
            categoryId = "cat_school",
            categoryName = "مدرسه و مهارتهای زندگی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "مدیریت زمان و قدردان لحظه‌ها بودن، زندگی را منظم و هدفمند می‌کند.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "عقربه‌های ساعت میدان بزرگ شهر ناگهان در عدد ۱۲ متوقف شدند و تمام ساعت‌های جبی هم خوابیدند!"
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "بچه‌ها ابتدا فکر کردند وقت بی‌نهایت برای بازی دارند، اما به‌زودی ناهار دیر شد و برنامه‌ها به هم خورد."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "آن‌ها فهمیدند نظم و برنامه داشتن چقدر ارزشمند است. با کوک کردن مجدد ساعت، زندگی به زیبایی جاری شد."
                )
            )
        ),

        // Story 27 (Bedtime Lullaby)
        Story(
            id = "story_27",
            title = "قصر رویای ستاره‌ها",
            description = "داستان بسیار آرامش‌بخش از سفر قایق کاغذی در رودخانه خنک شبانه تا قصر خواب لالایی.",
            ageGroup = "3-5",
            categoryId = "cat_bedtime",
            categoryName = "قصههای قبل از خواب",
            coverDrawable = "img_night",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "گوش دادن به لالایی آرام شبانه، جسم و روح کودک را غرق در آرامش می‌سازد.",
            isBedtimeStory = true,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "رودخانه‌ای آرام از میان دشت‌های شب‌تاب می‌گذشت و قایق کوچکی روی موج‌های نرمش تاب می‌خورد."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "فرشته ستاره‌ها با پودر درخشان نقره‌ای روی پلک‌های تمام بچه‌های دنیا لالایی مهربانی می‌پاشید."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "چشمانت را آرام ببند... فردا روزی پر از بازی و لبخند در انتظار توست. شب به‌خیر."
                )
            )
        ),

        // Story 28 (Technology & Safety)
        Story(
            id = "story_28",
            title = "پهپاد کوچک نجات",
            description = "پهپاد هوشمندی که با دوربین حرارتی در برف به نجات جوجه‌تیغی گمشده می‌شتابد.",
            ageGroup = "6-8",
            categoryId = "cat_science",
            categoryName = "علم و فناوری",
            coverDrawable = "img_hero",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "استفاده صحیح از فناوری جدید نجات‌بخش و یاری‌رسان موجودات زنده است.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "«وزززز!» پهپاد کوچولوی سفید با پروانه‌های چهارگانه‌اش بر فراز تپه‌های برفی پرواز می‌کرد."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "دوربین حرارتی پهپاد نقطه گرم کوچکی لای بوته‌ها شناسایی کرد: جوجه‌تیغی کوچولو راه خانه‌اش را گم کرده بود!"
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "پهپاد با نور فلش راه را نشان داد و جلیقه گرمی را برایش فرستاد تا به سلامتی به آغوش خانواده‌اش برگردد."
                )
            )
        ),

        // Story 29 (Nature & Perseverance)
        Story(
            id = "story_29",
            title = "باغبان خورشید و آفتابگردان",
            description = "داستان تلاش دخترکی که هر روز با خورشید سلام کرده و از دانه آفتابگردانش تا شکفتن مراقبت می‌کند.",
            ageGroup = "3-5",
            categoryId = "cat_nature",
            categoryName = "طبیعت و محیط زیست",
            coverDrawable = "img_hero",
            estimatedReadingTime = 3,
            hasAudio = true,
            moralLesson = "مداومت، صبر و رسیدگی عاشقانه، زیباترین نتیجه‌ها را ببار می‌آورد.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "بهار کوچولو دانه سیاه آفتابگردان را در گلدان سفالی بالکن کاشت و خاک نرم روی آن ریخت."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "او هر روز صبح با طلوع خورشید گلدانش را آب می‌داد و با شعر کوتاه با نهال گفتگو می‌کرد."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "تابستان که رسید، آفتابگردان طلایی بزرگ و خندانی رو به خورشید باز شد و بالکن خانه را غرق در نور کرد."
                )
            )
        ),

        // Story 30 (Creativity & Fantasy)
        Story(
            id = "story_30",
            title = "مداد رنگی جادویی",
            description = "جعبه مداد رنگی زرد و بنفشی که هر نقاشی کشیده شده با آن، اگر با هدف مهربانی باشد زنده می‌شود!",
            ageGroup = "6-8",
            categoryId = "cat_fantasy",
            categoryName = "فانتزی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "قدرت هنر وقتی با مهربانی ترکیب شود، معجزه می‌آفریند.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "مانی در روز تولدش جعبه مدادرنگی بنفش درخشانی هدیه گرفت که بوی گل یاس می‌داد."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "وقتی مانی یک سیب سرخ برای پیرزن خسته همسایه کشید، سیب واقعی از کاغذ بیرون آمد و معطر شد!"
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "مانی فهمید که این مدادها معجزه مهربانی هستند و از آن پس برای کمک به دیگران نقاشی‌های زیبا کشید."
                )
            )
        ),

        // Story 31 (Iranian Mythology / Folklore)
        Story(
            id = "story_31",
            title = "زال و مرغ افسانه‌ای سیمرغ",
            description = "داستان شگفت‌انگیز پرورش زال با موهای سپید توسط سیمرغ مهربان در بلندای کوه البرز.",
            ageGroup = "9-12",
            categoryId = "cat_fantasy",
            categoryName = "فانتزی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 5,
            hasAudio = true,
            moralLesson = "تفاوت‌های ظاهری نشان‌دهنده ارزش واقعی انسان نیستند؛ مهربانی حکمت اصلی است.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "در زمان‌های بسیار دور، کودکی با موهایی سپید مانند برف به دنیا آمد که او را زال نامیدند."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "سیمرغ پرنده بزرگ و دانا، او را به آشیانه خود بر بالای کوه البرز برد و مانند فرزندش با مهر و محبت بزرگ کرد."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "زال بزرگواری و حکمت فرا گرفت و سال‌ها بعد به یکی از پهلوانان و دانایان بزرگ ایران‌زمین تبدیل شد."
                )
            )
        ),

        // Story 32 (Nature & Growth)
        Story(
            id = "story_32",
            title = "سفر دانه‌ای به اسم جوانه",
            description = "داستان دانه‌ای کوچک در زیر خاک سیاه که با بارش باران و تابش خورشید به درختی تنومند تبدیل می‌شود.",
            ageGroup = "3-5",
            categoryId = "cat_nature",
            categoryName = "طبیعت و محیط زیست",
            coverDrawable = "img_hero",
            estimatedReadingTime = 3,
            hasAudio = true,
            moralLesson = "با صبر و امید، بزرگ‌ترین استعدادهای درون انسان شکوفا می‌شوند.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "جوانه دانه کوچکی بود که در دل خاک گرم و تاریک خوابیده بود و آرزوی دیدن آسمان را داشت."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "قطره‌های باران به او نوشیدنی خنک دادند و خورشید با گرمایش او را صدا زد: «بالا بیا جوانه کوچولو!»"
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "جوانه خاک را شکافت و سرش را بیرون آورد. حالا او بوته‌ای سرسبز با گل‌های معطر شده بود."
                )
            )
        ),

        // Story 33 (Moral & Forgiveness)
        Story(
            id = "story_33",
            title = "روباه کوچولو و راز بخشش",
            description = "داستان روباهی که وقتی دوستش حواستش نبود و اسباب‌بازی‌اش را شکست، معنای واقعی بخشش را آموخت.",
            ageGroup = "6-8",
            categoryId = "cat_family",
            categoryName = "خانواده و دوستی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "بخشش و گذشت، دوستی‌ها را پایدارتر و دل‌ها را آرام‌تر می‌کند.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "روباه کوچولو قایق چوبی قشنگی داشت که خیلی دوستش می‌داشت و همیشه با آن بازی می‌کرد."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "خرگوش بی‌هوا پایش به قایق خورد و قایق شکست. خرگوش با خجالت و گریه عذرخواهی کرد."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "روباه با لبخند اشک‌های دوستش را پاک کرد و گفت: «مهم نیست دوست من، با هم قایق جدیدی می‌سازیم!»"
                )
            )
        ),

        // Story 34 (Space & Bedtime)
        Story(
            id = "story_34",
            title = "قطار ستاره‌ای تا کهکشان آرزوها",
            description = "سفری خیال‌انگیز و ملایم با قطار طلایی در میان ابرهای بنفش شبانه تا سرزمین خواب‌های شیرین.",
            ageGroup = "3-5",
            categoryId = "cat_bedtime",
            categoryName = "قصههای قبل از خواب",
            coverDrawable = "img_night",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "آرامش شب و رویاپردازی زیبای کودکانه آماده‌ساز روزی پر از انرژی است.",
            isBedtimeStory = true,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "«چو چو...» قطار درخشان ستاره‌ای روی ریل‌های نقره‌ای در میان آسمان شب حرکت می‌کرد."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "کودکان روی صندلی‌های مخملی نرم نشسته‌ بودند و پودر آرزوهای طلایی را روی ستاره‌ها می‌پاشیدند."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "قطار به آرامی در ایستگاه خواب‌های شیرین ایستاد. چشمانت را ببند و به قصر رویاها برو."
                )
            )
        ),

        // Story 35 (Science & Technology)
        Story(
            id = "story_35",
            title = "اختراع شگفت‌انگیز آرش",
            description = "آرش پسرک خلاقی که با وسایل دورریختنی، ماشین پاک‌کننده هوشمند هوای دهکده را می‌سازد.",
            ageGroup = "9-12",
            categoryId = "cat_science",
            categoryName = "علم و فناوری",
            coverDrawable = "img_hero",
            estimatedReadingTime = 5,
            hasAudio = true,
            moralLesson = "خلاقیت و استفاده از مواد بازیافتی می‌تواند مشکلات بزرگ محیط زیست را حل کند.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "آرش عاشق جابه‌جا کردن چرخ‌دنده‌ها و بطری‌های پلاستیکی کهنه در کارگاه کوچکش بود."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "او با فیلترهای خورشیدی و آرماتورهای کوچک دکوری، دستگاهی ساخت که دود و گرد و غبار را جذب می‌کرد."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "وقتی دستگاه روشن شد، هوای اتاق پر از عطر گل سرخ شد و معلم مدرسه مدال مخترع کوچک را به او داد."
                )
            )
        ),

        // Story 36 (Animals & Friendship)
        Story(
            id = "story_36",
            title = "سنجاب فراموش‌کار و بلوط‌های طلایی",
            description = "سام سنجابه جای بلوط‌های زمستانی‌اش را یادش رفته بود اما پرندگان با راهنمایی به او کمک کردند.",
            ageGroup = "3-5",
            categoryId = "cat_animals",
            categoryName = "حیوانات",
            coverDrawable = "img_hero",
            estimatedReadingTime = 3,
            hasAudio = true,
            moralLesson = "همدلی و کمک به دوستان در مواقع نیاز، لبخند را به زندگی بازمی‌گرداند.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "سام سنجابه تمام پاییز بلوط جمع کرده بود اما پنهان‌گاهش زیر برف‌های سفید گم شده بود!"
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "کلاغ دانا و زاغچه درخشان از بالای درختان رد پای بلوط‌ها را دیدند و به سام نشان دادند."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "سام با خوشحالی جشنی به پا کرد و تمام پرندگان مهربان جنگل را به سفره عسل و بلوط دعوت نمود."
                )
            )
        ),

        // Story 37 (Fantasy & Books)
        Story(
            id = "story_37",
            title = "جزیره کتاب‌های پرنده",
            description = "در جزیره‌ای رازآلود، کتاب‌ها مانند پروانه‌ها پرواز می‌کردند و قصه‌هایشان را با صدای بلند می‌خواندند.",
            ageGroup = "6-8",
            categoryId = "cat_fantasy",
            categoryName = "فانتزی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "کتاب‌خوانی بال‌های پرواز اندیشه و تخیل انسان را باز می‌کند.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "نیکی با قایق بادبانی‌اش به جزیره‌ای رسید که جلد کتاب‌ها مانند بال‌های زری در آفتاب می‌درخشیدند."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "هر کتابی که نیکی باز می‌کرد، داستانش با تصاویر جادویی و برجسته در هوا شکل می‌گرفت!"
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "نیکی فهمید که با هر کتابی که می‌خواند، می‌تواند به دنیای جادویی جدیدی پرواز کند."
                )
            )
        ),

        // Story 38 (Emotions & Life Skills)
        Story(
            id = "story_38",
            title = "روزی که ابر سفید گریه کرد",
            description = "ابر کوچولو از اینکه دلش پر از باران شده بود ناراحت بود، اما وقتی دید زمین سیراب شد شادمان گشت.",
            ageGroup = "6-8",
            categoryId = "cat_school",
            categoryName = "مدرسه و مهارتهای زندگی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "ابراز احساسات و گریه کردن طبیعی است و گاهی باعث طراوت و سرسبزی زندگی می‌شود.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "ابر کوچولوی خاکستری احساس سنگینی می‌کرد و دلش می‌خواست گریه کند، اما خجالت می‌کشید."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "باد مهربان گفت: «گریه کن ابر کوچولو، باریدن نشانه مهربانی توست نه ضعف!»"
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "ابر قطرات بارانش را بارید؛ گل‌ها شکفتند، رنگین‌کمان در آسمان خندید و ابر سب سبک و سبک‌تر شد."
                )
            )
        ),

        // Story 39 (Music & Animals)
        Story(
            id = "story_39",
            title = "ارکستر بزرگ حیوانات جنگل",
            description = "دارکوب، قورباغه و بلبل با صداهای متفاوتشان صدایی هماهنگ و سمفونی زیبایی در جنگل خلق کردند.",
            ageGroup = "3-5",
            categoryId = "cat_animals",
            categoryName = "حیوانات",
            coverDrawable = "img_hero",
            estimatedReadingTime = 3,
            hasAudio = true,
            moralLesson = "تفاوت‌ها و تنوع صداها وقتی هماهنگ شوند، زیباترین آهنگ همکاری را می‌سازند.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "دارکوب با نوکش روی تنه درخت می‌زد: «تق تق!» قورباغه کنار برکه می‌گفت: «قور قور!»"
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "بلبل پیشنهاد داد: «بیایید با هم بنوازیم!» با رهبری بلبل، نوک‌زدن و قورقور کردن یک موزیک شاد شد."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "تمام حیوانات جنگل دور برکه جمع شدند و تا غروب خورشید با این آهنگ شاد رقصیدند."
                )
            )
        ),

        // Story 40 (Bedtime Lullaby)
        Story(
            id = "story_40",
            title = "فانوس دریایی شب‌های پرستاره",
            description = "فانوس دریایی با نور طلایی آرام‌بخش خود، کشتی‌های خسته را به ساحل آرامش و خواب هدایت می‌کند.",
            ageGroup = "3-5",
            categoryId = "cat_bedtime",
            categoryName = "قصههای قبل از خواب",
            coverDrawable = "img_night",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "احساس امنیت و روشنایی امید، خوابی عمیق و رویایی شیرین می‌آورد.",
            isBedtimeStory = true,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "بر فراز صخره‌ای بلند، فانوس دریایی کوچکی با نور گرم و طلایی‌اش میچرخید."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "موج‌های خنک دریا با ملایمت به صخره می‌خوردند و نغمه‌ای لالایی‌گونه برای ماهی‌های خواب‌آلود می‌خواندند."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "کشتی‌ها به ساحل امن رسیدند. فانوس چشمانش را خمار کرد... شبت بخیر کوچولوی نازنین."
                )
            )
        ),

        // Story 41 (Iranian Epic / Mythology)
        Story(
            id = "story_41",
            title = "رستم و اسب وفادارش رخش",
            description = "داستان شجاعت، پیوند دوستی و وفاداری میان رستم پهلوان نامدار ایرانی و اسب هوشمندش رخش.",
            ageGroup = "9-12",
            categoryId = "cat_fantasy",
            categoryName = "فانتزی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 5,
            hasAudio = true,
            moralLesson = "وفاداری، شجاعت و مراقبت از مرکب و دوست، نشان پهلوانی واقعی است.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "رستم پهلوان جوان در میان صدها اسب تیزرو، اسبی نیرومند با پوست گلگون دید که نامش رخش بود."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "رخش نه‌تنها اسبی پرسرعت بود، بلکه هوشی بالا داشت و در دشوارترین نبردها هوشیارانه از رستم پاسداری می‌کرد."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "پیوند دوستی رستم و رخش زبان‌زد همگان شد؛ چرا که دوستی راستین بر پایه یاری و وفاداری است."
                )
            )
        ),

        // Story 42 (Health & Life Skills)
        Story(
            id = "story_42",
            title = "شهر شکلاتی و فرشته دندان",
            description = "پسرکی که با خوردن بیش از حد شیرینی دندان‌درد می‌گیرد و با راهنمایی فرشته، مسواک زدن را دوست می‌دارد.",
            ageGroup = "6-8",
            categoryId = "cat_school",
            categoryName = "مدرسه و مهارتهای زندگی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "مراقبت از بهداشت دندان‌ها و تعادل در خوردن شیرینی، سلامتی و خنده‌ای زیبا می‌سازد.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "شایان در خواب دید به شهری رفته که دیوارهایش از شکلات و جاده‌هایش از پشمک ساخته شده!"
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "او زیاد شکلات خورد تا اینکه دندانش درد گرفت. فرشته دندان با مسواک درخشانش به یاری او آمد."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "فرشته به او نشان داد چطور با مسواک زدن و خمیردندان سفید، دندان‌هایش مثل مروارید می‌درخشند."
                )
            )
        ),

        // Story 43 (Persian Folklore)
        Story(
            id = "story_43",
            title = "ماه پیشونی و دیو مهربان",
            description = "بازآفرینی جذاب از قصه کهن ایرانی ماه پیشونی که با قلب پاکش، تاریکی را به روشنایی تبدیل می‌کند.",
            ageGroup = "6-8",
            categoryId = "cat_fantasy",
            categoryName = "فانتزی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 5,
            hasAudio = true,
            moralLesson = "نیکوکاری، ادب و پاکی درون، تاریک‌ترین قلعه‌ها را روشن می‌کند.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "دخترکی مهربان با ستاره‌ای بر پیشانی و ماه بر چهره، به قلعه دیو تنهایی در قلعه کوهستان رسید."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "ماه پیشونی به جای ترس، با خنده‌ای شیرین به دیو سلام کرد و باغچه غمگین قلعه را آب داد."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "دیو طلسم تاریکی‌اش شکست و گل‌های یاس در قلعه شکفتند؛ چرا که مهربانی بزرگ‌ترین جادوست."
                )
            )
        ),

        // Story 44 (Sports & Activity)
        Story(
            id = "story_44",
            title = "خرس تنبل و عسل جادویی",
            description = "خرس کوچولویی که فکر می‌کرد عسل جادویی او را قوی می‌کند، اما فهمید تمرین و ورزش راز اصلی است.",
            ageGroup = "6-8",
            categoryId = "cat_animals",
            categoryName = "حیوانات",
            coverDrawable = "img_hero",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "تلاش روزانه، حرکت و ورزش مداوم، بدن را سالم و شاداب می‌سازد.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "برفی خرس کوچولو همیشه گوشه‌ای لم می‌داد و آرزو داشت در مسابقه دویدن جنگل برنده شود."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "مربی آهو به او گفت: «این عسل جادویی فقط وقتی کار می‌کند که روزی ۲۰ دقیقه بدوی!»"
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "برفی هر روز تمرین کرد و در روز مسابقه دوم شد! او فهمید جادوی اصلی، ورزش و تلاش خودش بوده است."
                )
            )
        ),

        // Story 45 (Space Exploration)
        Story(
            id = "story_45",
            title = "سفینه کاغذی و سیاره رنگین‌کمان",
            description = "دخترکی که با تا کردن کاغذ، سفینه‌ای فضایی می‌سازد و به سیاره‌ای می‌رود که باران‌هایش رنگی است.",
            ageGroup = "3-5",
            categoryId = "cat_space",
            categoryName = "فضا و ماجراجویی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 3,
            hasAudio = true,
            moralLesson = "تخیل و بازی‌های خلاقانه، جهان کودک را شادمان و بی‌مرز می‌سازد.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "سارا با کاغذ بنفش بزرگش یک موشک کاغذی درست کرد و روی آن یک خورشید خندان کشید."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "در عالم خیال، موشک پرواز کرد و به سیاره‌ای رسید که رودخانه‌هایش شیرتوت‌فرنگی بودند!"
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "سارا با موجودات فضایی بنفش‌رنگ لی‌لی بازی کرد و سفره‌ای از ستاره‌های پولکی پهن نمود."
                )
            )
        ),

        // Story 46 (Diversity & Acceptance)
        Story(
            id = "story_46",
            title = "مداد شمعی‌های همسایه",
            description = "جعبه مداد شمعی‌هایی که ابتدا فکر می‌کردند رنگ خودشان قشنگ‌تر است اما با کشیدن نقاشی مشترک شاد شدند.",
            ageGroup = "6-8",
            categoryId = "cat_family",
            categoryName = "خانواده و دوستی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "تنوع و تفاوت‌های ما وقتی کنار هم قرار بگیرند، دنیایی زیبا و رنگارنگ می‌سازند.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "مداد شمعی آبی می‌گفت: «آسمان از همه قشنگ‌تر است!» قرمز می‌گفت: «نه، گل سرخ زیباتر است!»"
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "دخترک کاغذ سفیدی آورد؛ آبی دریا را کشید، قرمز خورشید غروب را و زرد ستاره‌ها را."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "مداد شمعی‌ها دیدند وقتی همه با هم روی یک کاغذ باشند، شاهکاری بی‌نظیر خلق می‌شود."
                )
            )
        ),

        // Story 47 (Bedtime Lullaby)
        Story(
            id = "story_47",
            title = "لالایی اقیانوس آرام",
            description = "قصه ملایم قبل از خواب درباره نهنگ مادری که فرزندش را در میان آب‌های گرم گهواره می‌جنباند.",
            ageGroup = "3-5",
            categoryId = "cat_bedtime",
            categoryName = "قصههای قبل از خواب",
            coverDrawable = "img_night",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "آغوش گرم مادر و نغمه لالایی، امن‌ترین پناهگاه برای خوابی شیرین است.",
            isBedtimeStory = true,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "در عمق آب‌های خنک و آبی اقیانوس، نهنگ مادر با نوایی آرام فرزند کوچکش را نوازش می‌کرد."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "حباب‌های درخشان مانند مروارید بالا می‌رفتند و ماهی‌های کوچک پلک‌هایشان را می‌بستند."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "اقیانوس آرام گرفت و مهتاب بر سطح آب درخشید. حالا وقت خوابی عمیق و زیباست."
                )
            )
        ),

        // Story 48 (History & Science)
        Story(
            id = "story_48",
            title = "باغ موزه تاریخ و زمان",
            description = "سفر آموزشی دو کودک به موزه‌ای که ساعت‌های آفتابی، آبی و شنی قدیم را نشان می‌دهد.",
            ageGroup = "9-12",
            categoryId = "cat_science",
            categoryName = "علم و فناوری",
            coverDrawable = "img_hero",
            estimatedReadingTime = 5,
            hasAudio = true,
            moralLesson = "آشنایی با تاریخ علم و اختراعات گذشته، دانش ما را برای آینده عمیق‌تر می‌کند.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "پویا و پرنیا وارد حیاط زیبای موزه شدند جایی که سایه شاخص خورشیدی زمان را نشان می‌داد."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "راهنما به آن‌ها جام آبی قدیم ایرانی و ساعت شنی زری را نشان داد که چطور بدون برق کار می‌کردند."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "بچه‌ها شگفت‌زده شدند از اینکه دانشمندان کهن چقدر با هوش و دقت رازهای زمان را کشف کرده بودند."
                )
            )
        ),

        // Story 49 (Courage & Self-confidence)
        Story(
            id = "story_49",
            title = "جوجه‌بطی شجاع در طوفان",
            description = "جوجه‌بطی کوچکی که از شنا در عمق می‌ترسید اما با رهایی دوستش از لای بوته‌ها شجاع شد.",
            ageGroup = "6-8",
            categoryId = "cat_animals",
            categoryName = "حیوانات",
            coverDrawable = "img_hero",
            estimatedReadingTime = 4,
            hasAudio = true,
            moralLesson = "شجاعت واقعی به معنای نترسیدن نیست، بلکه غلبه بر ترس برای کمک به دیگران است.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "پری جوجه‌بطی همیشه در قسمت کم‌عمق برکه پا می‌زد و از شنا در بخش عمیق می‌ترسید."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "وقتی باد شدید شاخه درختی را روی لانه ماهی گلی انداخت، پری ترسش را فراموش کرد و شیرجه زد."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "او شاخه را جابه‌جا کرد و ماهی گلی نجات یافت. همه برای پری شجاع دست زدند و او به خودش افتخار کرد."
                )
            )
        ),

        // Story 50 (Grand Celebration / Unity)
        Story(
            id = "story_50",
            title = "جشن بزرگ مهربانی در قصر قصه‌ها",
            description = "تمام شخصیت‌های قصه‌های مختلف دور هم جمع می‌شوند تا جشنی پر از کتاب، شعر و لبخند به پا کنند.",
            ageGroup = "6-8",
            categoryId = "cat_fantasy",
            categoryName = "فانتزی",
            coverDrawable = "img_hero",
            estimatedReadingTime = 5,
            hasAudio = true,
            moralLesson = "قصه‌ها و کتاب‌ها بزرگ‌ترین دوستانی هستند که همیشه لبخند و دانایی به ما می‌بخشند.",
            isBedtimeStory = false,
            pages = listOf(
                StoryPage(
                    pageNumber = 1,
                    text = "در قصر طلایی «قصه‌خانه»، سیمرغ، روباه دانا، کارآگاه روبو و ماه پیشونی دور یک سفره جمع شده بودند."
                ),
                StoryPage(
                    pageNumber = 2,
                    text = "دانا دستیار هوشمند قصه، نور آرزوها را روشن کرد و سرود دوستی و کتابخوانی در سراسر قصر پیچید."
                ),
                StoryPage(
                    pageNumber = 3,
                    text = "همه شخصیت‌ها با هم گفتند: «کتاب خواندن زیباترین پرواز رویاهاست. همیشه قصه بخوانید کوچولوها!»"
                )
            )
        )
    )
}

