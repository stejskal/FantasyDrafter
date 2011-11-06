var popoutOptions = ["#MyTeam", "#PickList", "#DraftHistory"];

function popoutTabClicked(clicked)
{
    if ($(clicked).hasClass('hidden'))
    {
        $(clicked).removeClass('hidden');
        $(clicked + "Tab").removeClass('hidden');
        for (var i = 0; i < popoutOptions.length; i++)
        {
            if (popoutOptions[i] != clicked)
            {
                $(popoutOptions[i]).addClass('hidden');
                $(popoutOptions[i] + "Tab").addClass('hidden');
            }
        }
    }
    else
    {
        for (var i = 0; i < popoutOptions.length; i++)
        {
            $(popoutOptions[i]).addClass('hidden');
            $(popoutOptions[i] + "Tab").removeClass('hidden');
        }
    }
}
