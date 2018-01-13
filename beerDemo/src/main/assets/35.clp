;;;***************************
;;;* DEFFACTS KNOWLEDGE BASE *
;;;***************************

(deffacts MAIN::knowledge-base
    (welcome (message WelcomeMessage))
    (goal (variable beer.type))
    (legalanswers (values yes no))
    (displayanswers (values "Yes" "No"))

    (rule (if advanced is yes)
          (then expertise is advanced))
    (rule (if advanced is no)
          (then expertise is novice))
    (question (variable advanced)
                  (query advanced.query))

    (rule (if expertise is novice and fruity is yes)
          (then category is ale))
    (rule (if expertise is novice and fruity is no)
          (then category is lager))
    (question (variable fruity)
                  (query fruity.query))

    (rule (if category is lager and high.alcohol is yes)
          (then beer.type is bock))
    (rule (if category is lager and high.alcohol is no)
          (then subcategory is pale.lager))
    (question (variable high.alcohol)
                  (query high.alcohol.query))

    (rule (if subcategory is pale.lager and hops is yes)
          (then beer.type is india.pale.lager))
    (rule (if subcategory is pale.lager and hops is no)
          (then beer.type is pale.lager))
    (question (variable hops)
               (query hops.query))

    (rule (if category is ale and high.alcohol is yes)
          (then subcategory is english.trappist))
    (rule (if category is ale and high.alcohol is no)
          (then subcategory is pale.dark.wheat))

    (rule (if subcategory is pale.dark.wheat and caramel is yes)
          (then beer.type is dark.ale))
    (rule (if subcategory is pale.dark.wheat and caramel is no)
          (then subsubcategory is pale.wheat))

    (rule (if subsubcategory is pale.wheat and dry is yes)
          (then beer.type is pale.ale))
    (rule (if subsubcategory is pale.wheat and dry is no)
          (then beer.type is wheat.ale))

    (rule (if subcategory is english.trappist and bitter is yes)
          (then subsubcategory is english.tripple))
    (rule (if subcategory is trappist and bitter is no)
          (then subsubcategory is dubbel.blonde))
    (question (variable bitter)
                  (query bitter.query))

    (rule (if subsubcategory is dubbel.blonde and caramel is yes)
          (then beer.type is dubbel.trappist))
    (rule (if subsubcategory is dubbel.blonde and caramel is no)
          (then beer.type is blonde.trappist))

    (rule (if subsubcategory is english.tripple and dry is yes)
          (then beer.type is triple.trappist))
    (rule (if subsubcategory is english.trappist and dry is no)
          (then beer.type is english.ipa))
    (question (variable caramel)
                  (query caramel.query))

    (rule (if expertise is advanced and cherry is yes)
          (then beer.type is kriek))
    (rule (if expertise is advanced and cherry is no)
          (then flavour is notcherry))
    (question (variable cherry)
                  (query cherry.query))

    (rule (if expertise is advanced and flavour is notcherry and dry is yes)
          (then beer.type is faro))
    (rule (if expertise is advanced and flavour is notcherry and dry is no)
          (then beer.type is gueuze))
    (question (variable dry)
                  (query dry.query))

    (answer (variable beer.type)))
