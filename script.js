function showSection(id){

    const sections =
        document.querySelectorAll(".content");

    sections.forEach(section=>{
        section.classList.remove("active");
    });

    document
        .getElementById(id)
        .classList.add("active");

}