/**
 * 
 */

 function toggleMenu() {
        const navbarLinksLeft = document.querySelector('.navbar-links.left');
        const navbarLinksRight = document.querySelector('.navbar-links.right');
        navbarLinksLeft.classList.toggle('active');
        navbarLinksRight.classList.toggle('active');
    }

    function toggleAdminDropdown() {
        const dropdown = document.getElementById('dropdown-content');
        dropdown.classList.toggle('show');
    }